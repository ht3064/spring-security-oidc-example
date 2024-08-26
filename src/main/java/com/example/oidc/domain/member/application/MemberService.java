package com.example.oidc.domain.member.application;

import com.example.oidc.domain.auth.dao.RefreshTokenRepository;
import com.example.oidc.domain.member.domain.Member;
import com.example.oidc.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberUtil memberUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    public void logoutMember() {
        final Member currentMember = memberUtil.getCurrentMember();
        refreshTokenRepository.deleteById(currentMember.getId());
    }
}
