package com.example.oidc.global.util;

import org.springframework.boot.web.server.Cookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import static com.example.oidc.global.common.constants.SecurityConstants.REFRESH_TOKEN_COOKIE_NAME;

@Component
public class CookieUtil {

    public HttpHeaders generateRefreshTokenCookie(String refreshToken) {

        String sameSite = determineSameSitePolicy();

        ResponseCookie refreshTokenCookie =
                ResponseCookie.from(REFRESH_TOKEN_COOKIE_NAME, refreshToken)
                        .path("/")
                        .secure(true)
                        .sameSite(sameSite)
                        .httpOnly(true)
                        .build();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());

        return headers;
    }

    public HttpHeaders deleteRefreshTokenCookie() {

        String sameSite = determineSameSitePolicy();

        ResponseCookie refreshTokenCookie =
                ResponseCookie.from(REFRESH_TOKEN_COOKIE_NAME, "")
                        .path("/")
                        .maxAge(0)
                        .secure(true)
                        .sameSite(sameSite)
                        .httpOnly(true)
                        .build();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());

        return headers;
    }

    private String determineSameSitePolicy() {
        return Cookie.SameSite.NONE.attributeValue();
    }
}