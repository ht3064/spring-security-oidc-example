package com.example.oidc.global.util;

import com.example.oidc.domain.member.dao.MemberRepository;
import com.example.oidc.domain.member.domain.Member;
import com.example.oidc.global.error.exception.CustomException;
import com.example.oidc.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberUtil {

    private final SecurityUtil securityUtil;
    private final MemberRepository memberRepository;

    public Member getCurrentMember() {
        return memberRepository
                .findById(securityUtil.getCurrentMemberId())
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    }
}