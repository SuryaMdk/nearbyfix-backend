package com.sss.nearbyfix.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "NearbyFixSecretKey"; // 🔐 Use stronger key in production
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    // Generate token using email or username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("NearbyFix")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Extract username (email) from token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Check token validity
    public boolean isTokenValid(String token) {
        try {
            Claims claims = extractAllClaims(token);
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Get all claims
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .setAllowedClockSkewSeconds(60)
                .parseClaimsJws(token)
                .getBody();
    }
}
