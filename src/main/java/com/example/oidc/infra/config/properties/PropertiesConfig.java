package com.example.oidc.infra.config.properties;

import com.example.oidc.infra.config.jwt.JwtProperties;
import com.example.oidc.infra.config.oauth.KakaoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
        JwtProperties.class,
        KakaoProperties.class
})
@Configuration
public class PropertiesConfig {
}
