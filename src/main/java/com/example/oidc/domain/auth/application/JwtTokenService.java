package com.example.oidc.domain.auth.application;

import com.example.oidc.domain.auth.dao.RefreshTokenRepository;
import com.example.oidc.domain.auth.domain.RefreshToken;
import com.example.oidc.domain.member.domain.MemberRole;
import com.example.oidc.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    public String createAccessToken(Long memberId, MemberRole memberRole) {
        return jwtUtil.generateAccessToken(memberId, memberRole);
    }

    public String createRefreshToken(Long memberId) {
        String token = jwtUtil.generateRefreshToken(memberId);
        RefreshToken refreshToken =
                RefreshToken.builder()
                        .memberId(memberId)
                        .token(token)
                        .build();
        refreshTokenRepository.save(refreshToken);
        return token;
    }
}