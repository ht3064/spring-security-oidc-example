package com.example.oidc.domain.auth.dto.response;

public record TokenPairResponse(String accessToken, String refreshToken) {
    public static TokenPairResponse of(String accessToken, String refreshToken) {
        return new TokenPairResponse(accessToken, refreshToken);
    }
}