package com.jestify.controller;

import com.jestify.jwt.JWTProvider;
import com.jestify.payload.AuthRequest;
import com.jestify.service.AuthService;
import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.entity.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;
    private final JWTProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest loginRequest, HttpServletResponse response) {
        log.info("{} login", loginRequest.getUsername());
        Users appUser = authService.checkLogin(loginRequest);
        if (appUser == null) {
            log.error("{} login fail", loginRequest.getUsername());
            ResponseCommon errorResponse = ResponseCommon.fail("Username or password is incorrect");
            return ResponseEntity.badRequest().body(errorResponse);
        } else {
            log.info("{} login success", loginRequest.getUsername());
            return ResponseEntity.ok(getAuthResponse(appUser, loginRequest.isRemember(), response));
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<Object> logOut(HttpServletResponse response) {
        addRefreshTokenToCookie(response, null, 0);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public ResponseEntity<Object> refreshToken(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, AppConstant.REFRESH_TOKEN_KEY);
        if (cookie == null || jwtProvider.isNoneValidRefreshToken(cookie.getValue())) {
            log.error("Refresh token fail");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Users appUser = jwtProvider.getUserFromToken(cookie.getValue());
        String accessToken = jwtProvider.generateAccessToken(appUser);
        return ResponseEntity.ok(Collections.singletonMap(AppConstant.ACCESS_TOKEN_KEY, accessToken));
    }

    private Map<String, String> getAuthResponse(Users appUser, boolean isRemember, HttpServletResponse response) {
        String accessToken = jwtProvider.generateAccessToken(appUser);
        String refreshToken = jwtProvider.generateRefreshToken(appUser, isRemember);
        addRefreshTokenToCookie(response, refreshToken, jwtProvider.getRefreshTokenLifeTimeMinutes(isRemember) * 60);

        return Collections.singletonMap(AppConstant.ACCESS_TOKEN_KEY, accessToken);
    }

    private void addRefreshTokenToCookie(HttpServletResponse response, String refreshToken, int maxAgeSeconds) {
        Cookie cookie = new Cookie(AppConstant.REFRESH_TOKEN_KEY, refreshToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/api/token/refresh");
        cookie.setMaxAge(maxAgeSeconds);
        response.addCookie(cookie);
    }
}
