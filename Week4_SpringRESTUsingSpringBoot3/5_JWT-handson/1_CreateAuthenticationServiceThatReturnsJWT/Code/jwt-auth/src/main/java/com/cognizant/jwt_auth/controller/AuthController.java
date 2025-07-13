package com.cognizant.jwt_auth.controller;

import com.cognizant.jwt_auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        // Decode Basic Auth
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String decodedCredentials = new String(decodedBytes); // "user:pwd"
        String username = decodedCredentials.split(":")[0];

        // Generate token
        String token = jwtUtil.generateToken(username);
        return Map.of("token", token);
    }
}