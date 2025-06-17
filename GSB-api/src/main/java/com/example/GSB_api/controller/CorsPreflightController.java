package com.example.GSB_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsPreflightController {
        @RequestMapping(value = "/api/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }
}
