package com.marbor.oauth.oauthsample.controllers;

import com.marbor.oauth.oauthsample.controllers.routes.Routes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(Routes.HELLO_ROUTE)
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
