package com.example.oidc.domain.auth.application;

import com.example.oidc.domain.auth.dto.response.KakaoTokenResponse;
import com.example.oidc.domain.auth.dto.response.SocialLoginResponse;
import com.example.oidc.domain.member.dao.MemberRepository;
import com.example.oidc.domain.member.domain.Member;
import com.example.oidc.domain.member.domain.OauthInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class AuthService {

    private final KakaoService kakaoService;
    private final JwtTokenService jwtTokenService;
    private final IdTokenVerifier idTokenVerifier;
    private final MemberRepository memberRepository;

    public SocialLoginResponse socialLoginMember(String code) {
        KakaoTokenResponse response = kakaoService.getOauthToken(code);
        String idToken = response.id_token();
        OidcUser oidcUser = idTokenVerifier.getOidcUser(idToken);

        Optional<Member> optionalMember = findByOidcUser(oidcUser);
        Member member = optionalMember.orElseGet(() -> saveMember(oidcUser));

        return getLoginResponse(member);
    }

    private SocialLoginResponse getLoginResponse(Member member) {
        String accessToken = jwtTokenService.createAccessToken(member.getId(), member.getRole());
        String refreshToken = jwtTokenService.createRefreshToken(member.getId());
        return SocialLoginResponse.of(accessToken, refreshToken);
    }

    private Optional<Member> findByOidcUser(OidcUser oidcUser) {
        OauthInfo oauthInfo = extractOauthInfo(oidcUser);
        return memberRepository.findByOauthInfo(oauthInfo);
    }

    private Member saveMember(OidcUser oidcUser) {
        OauthInfo oauthInfo = extractOauthInfo(oidcUser);
        Member member = Member.createNormalMember(oauthInfo);
        return memberRepository.save(member);
    }

    private OauthInfo extractOauthInfo(OidcUser oidcUser) {
        return OauthInfo.createOauthInfo(
                oidcUser.getSubject(), oidcUser.getNickName(), oidcUser.getPicture());
    }
}