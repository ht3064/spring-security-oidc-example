package com.example.oidc.domain.auth.dto.response;

public record KakaoTokenResponse(
        String token_type,
        String access_token,
        String id_token,
        String expires_in,
        String refresh_token,
        String refresh_token_expires_in,
        String scope) {
}