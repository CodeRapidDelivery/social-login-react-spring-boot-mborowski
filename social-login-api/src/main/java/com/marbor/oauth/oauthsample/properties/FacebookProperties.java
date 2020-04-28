package com.marbor.oauth.oauthsample.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "social-login-app.oauth.facebook")
@RequiredArgsConstructor
@Getter
@Setter
public class FacebookProperties {
    private String clientId;
    private String secret;
    private String redirect;
    private String api;
}
