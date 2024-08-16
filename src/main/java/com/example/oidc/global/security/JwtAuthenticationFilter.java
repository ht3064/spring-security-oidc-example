package com.example.oidc.global.security;

import com.example.oidc.domain.auth.application.JwtTokenService;
import com.example.oidc.domain.auth.dto.AccessTokenDto;
import com.example.oidc.domain.member.domain.MemberRole;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.example.oidc.global.common.constants.SecurityConstants.TOKEN_PREFIX;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String accessTokenHeaderValue = extractAccessTokenFromHeader(request);
        if (accessTokenHeaderValue != null) {
            AccessTokenDto accessTokenDto = jwtTokenService.retrieveAccessToken(accessTokenHeaderValue);
            if (accessTokenDto != null) {
                setAuthenticationToken(accessTokenDto.memberId(), accessTokenDto.memberRole());
            }
        }

        filterChain.doFilter(request, response);
    }

    private void setAuthenticationToken(Long memberId, MemberRole memberRole) {
        UserDetails userDetails =
                User.withUsername(memberId.toString())
                        .password("")
                        .authorities(memberRole.toString())
                        .build();
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(token);
    }

    private String extractAccessTokenFromHeader(HttpServletRequest request) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            return header.replace(TOKEN_PREFIX, "");
        }
        return null;
    }
}