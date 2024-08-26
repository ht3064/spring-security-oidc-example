package com.example.oidc.domain.member.api;

import com.example.oidc.domain.member.application.MemberService;
import com.example.oidc.global.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final CookieUtil cookieUtil;

    @DeleteMapping("/logout")
    public ResponseEntity<Void> MemberLogout() {
        memberService.logoutMember();

        HttpHeaders headers = cookieUtil.deleteRefreshTokenCookie();

        return ResponseEntity.ok().headers(headers).build();
    }
}