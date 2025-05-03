package com.rezarvasyon.saha.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    // Username (email) çıkarma
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // userType çıkarma (örneğin: "USER" veya "RESTAURANT")
    public String extractUserType(String token) {
        return extractClaim(token, claims -> claims.get("userType", String.class));
    }

    // Generic claim çekme
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Token oluşturma (default claims ile)
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // Token oluşturma (extra claims ile)
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    // Token oluşturma (userType içeren versiyon)
    public String generateToken(UserDetails userDetails, String userType) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userType", userType);
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    // Token süresi alma
    public long getExpirationTime() {
        return jwtExpiration;
    }

    // Token üretme (temel yapı)
    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Token doğrulama
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    // Expired kontrolü
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Expiration bilgisi çıkarma
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Tüm claim'leri çıkarma
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Signing key çözme
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
