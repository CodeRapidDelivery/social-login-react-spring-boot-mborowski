package com.marbor.oauth.oauthsample.controllers;

import static com.marbor.oauth.oauthsample.controllers.routes.Routes.IS_AUTHENTICATED_ROUTE;

import java.security.Principal;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountController {

    @GetMapping(IS_AUTHENTICATED_ROUTE)
    public ResponseEntity<String> isAuthenticated(Principal principal) {
        log.debug("User: {}", principal);
        final var name = Optional.ofNullable(principal)
                              .map(Principal::getName)
                              .orElse("");

        return new ResponseEntity<>(name, HttpStatus.OK);
    }
}