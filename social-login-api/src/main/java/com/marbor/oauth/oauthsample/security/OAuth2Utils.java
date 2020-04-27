package com.marbor.oauth.oauthsample.security;

import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import java.util.Map;
import java.util.Optional;

final class OAuth2Utils {

    public static final String CODE = "code";

    static boolean isOauthAccessTokenRequest(ServletRequest request) {
        return StringUtils.hasText(
                maybeOauthCode(request.getParameterMap())
                        .orElse("")
        );
    }

    static String extractOauthCode(ServletRequest request) {
        return maybeOauthCode(request.getParameterMap())
                .orElseThrow(() -> new RuntimeException("There is no oauth code parameter"));
    }

    private static Optional<String> maybeOauthCode(Map<String, String[]> params) {
        return Optional.ofNullable(params.get(CODE))
                .filter(values -> values.length > 0)
                .map(v -> v[0]);
    }

    private OAuth2Utils() {
    }
}