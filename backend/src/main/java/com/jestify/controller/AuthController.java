package com.jestify.controller;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.entity.Users;
import com.jestify.jwt.JWTProvider;
import com.jestify.payload.AuthRequest;
import com.jestify.payload.AuthResponse;
import com.jestify.payload.RegisterRequest;
import com.jestify.payload.ResetPasswordRequest;
import com.jestify.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;
    private final JWTProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest payload, HttpServletRequest request) {
        try {
            authService.register(payload, request);
            return ResponseEntity.ok(ResponseCommon.success(""));
        } catch (IllegalArgumentException e) {
            log.error("API /api/register: ", e);
            return ResponseEntity.ok().body(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API /api/register: ", e);
            return ResponseEntity.internalServerError().body(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/verify-register")
    public ResponseEntity<?> verifyRegister(@RequestParam String key) {
        try {
            authService.verifyRegister(key);
            return ResponseEntity.ok(ResponseCommon.success(""));
        } catch (Exception e) {
            log.error("API /api/verify-register: ", e);
            return ResponseEntity.internalServerError().body(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        try {
            authService.forgotPassword(email);
            return ResponseEntity.ok(ResponseCommon.success(""));
        } catch (IllegalArgumentException e) {
            log.error("API /api/forgot-password: ", e);
            return ResponseEntity.ok().body(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API /api/forgot-password: ", e);
            return ResponseEntity.internalServerError().body(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/verify-forgot-password")
    public ResponseEntity<?> verifyForgotPassword(@RequestParam String key) {
        try {
            authService.verifyForgotPassword(key);
            return ResponseEntity.ok(ResponseCommon.success(""));
        } catch (IllegalArgumentException e) {
            log.error("API /api/verify-forgot-password: ", e);
            return ResponseEntity.ok().body(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API /api/verify-forgot-password: ", e);
            return ResponseEntity.internalServerError().body(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
        try {
            authService.resetPassword(request);
            return ResponseEntity.ok(ResponseCommon.success(""));
        } catch (IllegalArgumentException e) {
            log.error("API /api/reset-password: ", e);
            return ResponseEntity.ok().body(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API /api/reset-password: ", e);
            return ResponseEntity.internalServerError().body(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody AuthRequest loginRequest, HttpServletResponse response) {
        try {
            Users appUser = authService.checkLoginCustomer(loginRequest);
            AuthResponse authResponse = getAuthResponse(appUser, loginRequest.isRemember(), response);
            return ResponseEntity.ok(ResponseCommon.success(authResponse));
        } catch (IllegalArgumentException e) {
            log.error("API /api/login: ", e);
            return ResponseEntity.ok().body(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API /api/login: ", e);
            return ResponseEntity.internalServerError().body(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @PostMapping("/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AuthRequest loginRequest, HttpServletResponse response) {
        try {
            Users appUser = authService.checkLoginAdmin(loginRequest);
            AuthResponse authResponse = getAuthResponse(appUser, loginRequest.isRemember(), response);
            return ResponseEntity.ok(ResponseCommon.success(authResponse));
        } catch (IllegalArgumentException e) {
            log.error("API /api/admin/login: ", e);
            return ResponseEntity.ok().body(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API /api/admin/login: ", e);
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
        cookie.setPath("/");
        cookie.setMaxAge(maxAgeSeconds);
        response.addCookie(cookie);
    }
}