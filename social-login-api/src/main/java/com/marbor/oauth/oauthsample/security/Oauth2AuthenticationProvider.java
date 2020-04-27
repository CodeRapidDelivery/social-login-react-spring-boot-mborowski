package com.marbor.oauth.oauthsample.security;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Oauth2AuthenticationProvider implements AuthenticationProvider {
    private final FacebookOauthService facebookOauthService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final var oauth2AuthenticationToken = (Oauth2AuthenticationToken) authentication;
        final var accessToken = facebookOauthService.getAccessToken(oauth2AuthenticationToken.getCode());
        final var identity = facebookOauthService.getIdentity(accessToken.getToken());
        final var authorities = Set.of(new SimpleGrantedAuthority("ROLE_USER"));

        return new Oauth2AuthenticationToken(
                new OauthUserPrincipal(identity.getId(), identity.getName(), identity.getEmail()), authorities
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return Oauth2AuthenticationToken.class.isAssignableFrom(authentication);
    }
}
