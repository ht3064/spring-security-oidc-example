package com.example.oidc.domain.auth.api;

import com.example.oidc.domain.auth.application.AuthService;
import com.example.oidc.domain.auth.dto.request.AuthCodeRequest;
import com.example.oidc.domain.auth.dto.response.SocialLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/social-login")
    public SocialLoginResponse memberSocialLogin(@RequestBody AuthCodeRequest request) {
        return authService.socialLoginMember(request.code());
    }
}