package com.example.oidc.domain.auth.dto;

public record RefreshTokenDto(Long memberId, String refreshTokenValue, Long expiredTime) {
    public static RefreshTokenDto of(Long memberId, String refreshTokenValue, Long expiredTime) {
        return new RefreshTokenDto(memberId, refreshTokenValue, expiredTime);
    }
}