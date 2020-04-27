package com.marbor.oauth.oauthsample.controllers.routes;

public class Routes {
    public static final String V1_API = "/v1/api";
    public static final String IS_AUTHENTICATED_ROUTE = V1_API + "/authenticate";
    public static final String OAUTH2_LOGIN_ROUTE = V1_API + "/oauth/login";
    public static final String HELLO_ROUTE = V1_API + "/hello";

    private Routes() {
    }
}
