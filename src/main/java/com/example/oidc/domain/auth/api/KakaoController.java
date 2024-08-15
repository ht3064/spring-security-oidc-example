package com.example.oidc.domain.auth.api;

import com.example.oidc.domain.auth.application.KakaoService;
import com.example.oidc.domain.auth.dto.request.AuthCodeRequest;
import com.example.oidc.domain.auth.dto.response.KakaoTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;

    @PostMapping("/login")
    public KakaoTokenResponse getOauthToken(@RequestBody AuthCodeRequest request) {
        return kakaoService.getOauthToken(request.code());
    }
}