package com.marbor.oauth.oauthsample.security;

import java.util.Collection;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;

@ToString
final public class Oauth2AuthenticationToken extends AbstractAuthenticationToken {
    private String code;
    private AuthenticatedPrincipal principal;

    public Oauth2AuthenticationToken(String code) {
        super(Collections.emptyList());
        this.code = code;
        setAuthenticated(false);
    }

    public Oauth2AuthenticationToken(AuthenticatedPrincipal principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public AuthenticatedPrincipal getPrincipal() {
        return this.principal;
    }

    public String getCode() {
        return code;
    }
}

