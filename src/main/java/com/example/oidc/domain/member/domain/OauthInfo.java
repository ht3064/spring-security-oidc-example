package com.example.oidc.domain.member.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OauthInfo {

    private String oauthId;
    private String nickname;
    private String profileImageUrl;

    @Builder(access = AccessLevel.PRIVATE)
    private OauthInfo(
            String oauthId, String nickname, String profileImageUrl) {
        this.oauthId = oauthId;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public static OauthInfo createOauthInfo(
            String oauthId, String nickname, String profileImageUrl) {
        return OauthInfo.builder()
                .oauthId(oauthId)
                .nickname(nickname)
                .profileImageUrl(profileImageUrl)
                .build();
    }
}