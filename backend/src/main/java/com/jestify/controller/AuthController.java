package com.jestify.controller;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.entity.Users;
import com.jestify.jwt.JWTProvider;
import com.jestify.payload.AuthRequest;
import com.jestify.payload.AuthResponse;
import com.jestify.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;
    private final JWTProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest loginRequest, HttpServletResponse response) {
        try {
            Users appUser = authService.checkLogin(loginRequest);
            AuthResponse authResponse = getAuthResponse(appUser, loginRequest.isRemember(), response);
            return ResponseEntity.ok(ResponseCommon.success(authResponse));
        } catch (IllegalArgumentException e) {
            log.error("API /api/login: ", e);
            return ResponseEntity.badRequest().body(ResponseCommon.fail("Username or password is incorrect"));
        } catch (Exception e) {
            log.error("API /api/login: ", e);
            return ResponseEntity.internalServerError().body(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<Object> logOut(HttpServletResponse response) {
        addRefreshTokenToCookie(response, null, 0);
        return ResponseEntity.ok().body(ResponseCommon.success(null));
    }

    @GetMapping("/token/refresh")
    public ResponseEntity<Object> refreshToken(@CookieValue(value = AppConstant.REFRESH_TOKEN_KEY, required = false) Cookie tokenCookie) {
        if (tokenCookie == null || jwtProvider.isNoneValidRefreshToken(tokenCookie.getValue())) {
            log.error("Fail to refresh token.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Users appUser = jwtProvider.getUserFromToken(tokenCookie.getValue());
        String accessToken = jwtProvider.generateAccessToken(appUser);
        AuthResponse authResponse = AuthResponse.builder().accessToken(accessToken).build();
        return ResponseEntity.ok(ResponseCommon.success(authResponse));
    }

    private AuthResponse getAuthResponse(Users appUser, boolean isRemember, HttpServletResponse response) {
        String accessToken = jwtProvider.generateAccessToken(appUser);
        String refreshToken = jwtProvider.generateRefreshToken(appUser, isRemember);
        addRefreshTokenToCookie(response, refreshToken, jwtProvider.getRefreshTokenLifeTimeMinutes(isRemember) * 60);
        return AuthResponse.builder().accessToken(accessToken).build();
    }

    private void addRefreshTokenToCookie(HttpServletResponse response, String refreshToken, int maxAgeSeconds) {
        Cookie cookie = new Cookie(AppConstant.REFRESH_TOKEN_KEY, refreshToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/api/token/refresh");
        cookie.setMaxAge(maxAgeSeconds);
        response.addCookie(cookie);
    }
}