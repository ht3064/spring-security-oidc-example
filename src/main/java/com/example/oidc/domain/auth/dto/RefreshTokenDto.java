package com.example.oidc.domain.auth.dto;

public record RefreshTokenDto(Long memberId, String refreshTokenValue, long ttl) {
    public static RefreshTokenDto of(Long memberId, String refreshTokenValue, long ttl) {
        return new RefreshTokenDto(memberId, refreshTokenValue, ttl);
    }
}