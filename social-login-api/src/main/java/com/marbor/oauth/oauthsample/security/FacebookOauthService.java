package com.marbor.oauth.oauthsample.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.marbor.oauth.oauthsample.properties.FacebookProperties;
import com.marbor.oauth.oauthsample.security.dto.AccessTokenResponse;
import com.marbor.oauth.oauthsample.security.dto.IdentityResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class FacebookOauthService {
    private final RestTemplate restTemplate;
    private final FacebookProperties facebookProperties;

    public AccessTokenResponse getAccessToken(String code) {
        final var accessTokenUrl = UriComponentsBuilder
                .fromUriString(facebookProperties.getApi() + "/oauth/access_token")
                .queryParam("client_id", facebookProperties.getClientId())
                .queryParam("client_secret", facebookProperties.getSecret())
                .queryParam("code", code)
                .queryParam("redirect_uri", facebookProperties.getRedirect())
                .toUriString();
        log.debug("Retrieving an access token from: " + accessTokenUrl);
        final var response = restTemplate.getForObject(accessTokenUrl, AccessTokenResponse.class);
        log.debug("Response from /oauth/access_token: {}", response );

        return response;
    }

    public IdentityResponse getIdentity(String accessToken){
        final var userInfoUrl = UriComponentsBuilder
                .fromUriString(facebookProperties.getApi() + "/me")
                .queryParam("access_token", accessToken)
                .queryParam("fields","id,name,email")
                .toUriString();

        final var identityResponse = restTemplate.getForObject(userInfoUrl, IdentityResponse.class);
        log.debug("Response from facebook /me: {}", identityResponse);

        return identityResponse;
    }
}
