package com.example.oidc.domain.auth.application;

import com.example.oidc.domain.auth.dto.response.KakaoTokenResponse;
import com.example.oidc.global.util.KakaoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoUtil kakaoUtil;

    public KakaoTokenResponse getOauthToken(String code) {
        return kakaoUtil.getOauthToken(code);
    }
}