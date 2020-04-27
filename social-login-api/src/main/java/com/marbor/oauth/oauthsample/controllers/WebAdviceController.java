package com.marbor.oauth.oauthsample.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class WebAdviceController {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<HttpStatus> handleException(Exception ex) {
        log.error("Exception occurred:", ex);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
