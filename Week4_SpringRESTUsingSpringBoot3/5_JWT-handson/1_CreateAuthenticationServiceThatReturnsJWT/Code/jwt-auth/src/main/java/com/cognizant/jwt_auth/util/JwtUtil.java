package com.cognizant.jwt_auth.util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtUtil {

    private static final String SECRET = "your-256-bit-secret"; // use a long random string

    public String generateToken(String username) {
        long expirationTime = 60 * 60 * 1000; // 1 hour

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
                .compact();
    }
}
