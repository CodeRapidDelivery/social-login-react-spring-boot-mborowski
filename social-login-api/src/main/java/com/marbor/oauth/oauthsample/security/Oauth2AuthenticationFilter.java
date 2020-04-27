package com.marbor.oauth.oauthsample.security;

import static com.marbor.oauth.oauthsample.controllers.routes.Routes.OAUTH2_LOGIN_ROUTE;
import static com.marbor.oauth.oauthsample.security.OAuth2Utils.extractOauthCode;
import static com.marbor.oauth.oauthsample.security.OAuth2Utils.isOauthAccessTokenRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Oauth2AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public Oauth2AuthenticationFilter(AuthenticationManager authenticationManager) {
        super(OAUTH2_LOGIN_ROUTE);
        this.setAuthenticationManager(authenticationManager);
        this.setAuthenticationSuccessHandler(Oauth2AuthenticationFilter.getCustomSuccessHandler());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!isOauthAccessTokenRequest(request)) {
            throw new OAuth2AuthenticationException("This is wrong oauth2 authentication request - missing oauth2 code.");
        }
        final var code = extractOauthCode(request);
        final var oauth2AuthenticationToken = new Oauth2AuthenticationToken(code);

        return this.getAuthenticationManager().authenticate(oauth2AuthenticationToken);
    }

    private static AuthenticationSuccessHandler getCustomSuccessHandler() {
        return (request, response, authentication) -> {
            response.setContentType(MediaType.TEXT_PLAIN_VALUE);
            final var name = SecurityContextHolder.getContext().getAuthentication().getName();

            response.getOutputStream().print(name);
        };
    }
}
