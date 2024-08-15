package com.example.oidc.infra.config.feign;

import com.example.oidc.domain.auth.dto.response.KakaoTokenResponse;
import com.example.oidc.global.config.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.oidc.global.common.constants.SecurityConstants.KAKAO_LOGIN_ENDPOINT;
import static com.example.oidc.global.common.constants.SecurityConstants.KAKAO_LOGIN_URL;

@FeignClient(
        name = "kakaoOauthClient",
        url = KAKAO_LOGIN_URL,
        configuration = FeignConfig.class)
public interface KakaoOauthClient {
    @PostMapping(value = KAKAO_LOGIN_ENDPOINT)
    KakaoTokenResponse getOauthToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code,
            @RequestParam("client_secret") String clientSecret);
}