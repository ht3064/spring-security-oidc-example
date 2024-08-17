package com.example.oidc.domain.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record SocialLoginResponse(String accessToken, @JsonIgnore String refreshToken) {
    public static SocialLoginResponse of(TokenPairResponse response) {
        return new SocialLoginResponse(response.accessToken(), response.refreshToken());
    }
}