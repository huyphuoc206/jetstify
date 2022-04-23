package com.web.project.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.impl.PublicClaims;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.web.project.common.AppConstant;
import com.web.project.entity.Role;
import com.web.project.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JWTProvider {

    private static final Algorithm algorithm = Algorithm.HMAC256(AppConstant.SECRET_KEY);

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
        return Users.builder()
                .username(getClaimValue(token, PublicClaims.SUBJECT, String.class))
                .roles((List<Role>) getClaimValue(token, AppConstant.ROLES_CLAIM, List.class).stream()
                        .map(e -> Role.builder().name(String.valueOf(e)).build())
                        .collect(Collectors.toList()))
                .build();
    }

    public String generateAccessToken(Users user) {
        return this.getToken(user, AppConstant.ACCESS_TOKEN_LIFE_TIME_MINUTES, false);
    }

    public String generateRefreshToken(Users user, boolean isRememberMe) {
        return this.getToken(user, this.getRefreshTokenLifeTimeMinutes(isRememberMe), true);
    }

    public int getRefreshTokenLifeTimeMinutes(boolean isRememberMe) {
        return isRememberMe ? AppConstant.REMEMBER_ME_EXPIRED_DAYS * 24 * 60 : AppConstant.REFRESH_TOKEN_LIFE_TIME_MINUTES;
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

        creator.withClaim(AppConstant.ROLES_CLAIM, appUser.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return creator.sign(algorithm);
    }
}
