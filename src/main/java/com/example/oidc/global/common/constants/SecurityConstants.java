package com.example.oidc.global.common.constants;

public final class SecurityConstants {
    public static final String TOKEN_ROLE_NAME = "role";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String KAKAO_LOGIN_URL = "https://kauth.kakao.com";
    public static final String KAKAO_LOGIN_ENDPOINT = "/oauth/token";

    public static final String KAKAO_JWK_SET_URL = "https://kauth.kakao.com/.well-known/jwks.json";
    public static final String KAKAO_ISSUER = "https://kauth.kakao.com";

    public static final String REFRESH_TOKEN_COOKIE_NAME = "refreshToken";
}