package com.example.oidc.global.util;

import com.example.oidc.domain.auth.dto.response.KakaoTokenResponse;
import com.example.oidc.infra.config.feign.KakaoOauthClient;
import com.example.oidc.infra.config.oauth.KakaoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KakaoUtil {

    private final KakaoOauthClient kakaoOauthClient;
    private final KakaoProperties kakaoProperties;

    public KakaoTokenResponse getOauthToken(String code) {
        return kakaoOauthClient.getOauthToken(
                kakaoProperties.grantType(),
                kakaoProperties.clientId(),
                kakaoProperties.redirectUri(),
                code,
                kakaoProperties.clientSecret());
    }
}