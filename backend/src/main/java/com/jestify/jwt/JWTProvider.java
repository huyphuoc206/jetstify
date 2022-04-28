package com.jestify.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.impl.PublicClaims;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jestify.common.AppConstant;
import com.jestify.entity.Role;
import com.jestify.entity.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class JWTProvider {

    private static final Algorithm algorithm = Algorithm.HMAC256(AppConstant.SECRET_KEY);
    private final TokenProperties properties;

    public boolean isValidAccessToken(String token) {
        return !isNoneValidAccessToken(token);
    }

    public boolean isNoneValidAccessToken(String token) {
        if (isNoneValidToken(token)) return true;
        Boolean isAccessToken = getClaimValue(token, AppConstant.ACCESS_TOKEN_CLAIM, Boolean.class);
        return isAccessToken == null || Boolean.FALSE.equals(isAccessToken);
    }

    public boolean isNoneValidRefreshToken(String token) {
        if (isNoneValidToken(token)) return true;
        Boolean isRefreshToken = getClaimValue(token, AppConstant.REFRESH_TOKEN_CLAIM, Boolean.class);
        return isRefreshToken == null || Boolean.FALSE.equals(isRefreshToken);
    }

    public Users getUserFromToken(String token) {
        if (isNoneValidToken(token)) return null;
        List<Role> roles = Arrays.stream(Objects.requireNonNull(getClaimValue(token, AppConstant.ROLES_CLAIM, String.class))
                .split(", "))
                .collect(Collectors.toList())
                .stream().map(e -> Role.builder().code(e).build())
                .collect(Collectors.toList());
        return Users.builder()
                .username(getClaimValue(token, PublicClaims.SUBJECT, String.class))
                .roles(roles)
                .build();
    }

    public String generateAccessToken(Users user) {
        return this.getToken(user, this.properties.getToken().getAccessLifetimeMinutes(), false);
    }

    public String generateRefreshToken(Users user, boolean isRememberMe) {
        return this.getToken(user, this.getRefreshTokenLifeTimeMinutes(isRememberMe), true);
    }

    public int getRefreshTokenLifeTimeMinutes(boolean isRememberMe) {
        return isRememberMe ? this.properties.getRememberMe().getExpiredDays() * 24 * 60 : this.properties.getToken().getRefreshLifetimeMinutes();
    }

    private boolean isNoneValidToken(String token) {
        if (StringUtils.isEmpty(token)) return true;
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decoded = verifier.verify(token);
            Long expiredTime = decoded.getExpiresAt().getTime();
            return System.currentTimeMillis() >= expiredTime;
        } catch (JWTVerificationException ex) {
            log.error("Token is invalid: {}", token, ex);
        }
        return true;
    }

    private <T> T getClaimValue(String token, String claimName, Class<T> clazz) {
        if (isNoneValidToken(token)) return null;
        DecodedJWT decoded = JWT.decode(token);
        return decoded.getClaim(claimName).as(clazz);
    }

    private String getToken(Users appUser, int expiredMinutes, boolean isRefreshToken) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, expiredMinutes);

        JWTCreator.Builder creator = JWT.create()
                .withSubject(appUser.getUsername())
                .withExpiresAt(calendar.getTime())
                .withIssuedAt(new Date())
                .withClaim("fullName", appUser.getFullName());

        if (isRefreshToken) {
            creator.withClaim(AppConstant.REFRESH_TOKEN_CLAIM, true);
        } else {
            creator.withClaim(AppConstant.ACCESS_TOKEN_CLAIM, true);
        }

        creator.withClaim(AppConstant.ROLES_CLAIM, appUser.getRoles()
                .stream()
                .map(Role::getCode)
                .collect(Collectors.joining(", ")));
        return creator.sign(algorithm);
    }
}
