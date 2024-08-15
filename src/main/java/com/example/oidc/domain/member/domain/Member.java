package com.example.oidc.domain.member.domain;

import com.example.oidc.domain.common.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Embedded
    private OauthInfo oauthInfo;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Builder(access = AccessLevel.PRIVATE)
    private Member(
            OauthInfo oauthInfo, MemberRole role, MemberStatus status) {
        this.oauthInfo = oauthInfo;
        this.role = role;
        this.status = status;
    }

    public static Member createNormalMember(OauthInfo oauthInfo) {
        return Member.builder()
                .oauthInfo(oauthInfo)
                .role(MemberRole.USER)
                .status(MemberStatus.NORMAL)
                .build();
    }
}