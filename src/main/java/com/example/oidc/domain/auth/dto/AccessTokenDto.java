package com.example.oidc.domain.auth.dto;

import com.example.oidc.domain.member.domain.MemberRole;

public record AccessTokenDto(Long memberId, MemberRole memberRole, String accessTokenValue) {
    public static AccessTokenDto of(Long memberId, MemberRole memberRole, String accessTokenValue) {
        return new AccessTokenDto(memberId, memberRole, accessTokenValue);
    }
}