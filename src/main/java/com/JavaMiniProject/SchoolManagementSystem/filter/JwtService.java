package com.JavaMiniProject.SchoolManagementSystem.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Service
public class JwtService {
    private static final String SecretKey = "iK12G/Bz7gvfV93bM5MvD6aa3U1rq3MsjpUfsSBms8GKtNAJkAKryaMmu+Erp1HDLHVUsOXPE3IIV4415qFdLNbuGrLciga8dhi0t98s+dU=\n";

    public String extractEmail(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    public <T> T extractClaim(String jwt, Function<Claims, T> claimResolver) {
        Claims claims = extractAllClaims(jwt);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    // Updated generateToken method to include email as subject
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        // Set the email as the subject claim
        claims.put("sub", userDetails.getUsername()); // Assuming username is the email

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Token valid for 24 hours
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Ensure you're using HS256
                .compact(); // This method handles encoding and returning the final JWT string
    }

    public boolean validateToken(String jwt, UserDetails userDetails) {
        final String username = extractEmail(jwt);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(jwt);
    }

    private boolean isTokenExpired(String jwt) {
        return issuedAt(jwt).before(new Date());
    }

    private Date issuedAt(String jwt) {
        return extractClaim(jwt, Claims::getExpiration);
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SecretKey);
        return hmacShaKeyFor(keyBytes);
    }
}