package com.marbor.oauth.oauthsample.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IdentityResponse {
    private String id;
    private String name;
    private String email;
}
