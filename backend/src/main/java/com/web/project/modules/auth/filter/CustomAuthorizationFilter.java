package com.web.project.modules.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.project.common.AppConstant;
import com.web.project.common.ResponseCommon;
import com.web.project.modules.auth.jwt.JWTProvider;
import com.web.project.modules.user.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith(AppConstant.BEARER)) {
            try {
                String token = authorizationHeader.substring(AppConstant.BEARER.length());
                if (jwtProvider.isValidAccessToken(token)) {
                    Users appUser = jwtProvider.getUserFromToken(token);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(appUser.getUsername(), null,
                            appUser.getRoles().stream().map(e -> new SimpleGrantedAuthority(e.getName())).collect(Collectors.toList()));
                    // add prefix ROLE_ to role name to security match url can use hasAnyRole
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } else {
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    ResponseCommon responseCommon = ResponseCommon.error("Token is invalid");
                    new ObjectMapper().writeValue(response.getOutputStream(), responseCommon);
                }
            } catch (Exception exception) {
                log.error("Error request: {}", exception.getMessage());
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}