package com.marbor.oauth.oauthsample.security;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.AuthenticatedPrincipal;

@RequiredArgsConstructor
@ToString
public class OauthUserPrincipal implements AuthenticatedPrincipal {
    private final String id;
    private final String name;
    private final String email;

    @Override
    public String getName() {
        return this.name;
    }
}
