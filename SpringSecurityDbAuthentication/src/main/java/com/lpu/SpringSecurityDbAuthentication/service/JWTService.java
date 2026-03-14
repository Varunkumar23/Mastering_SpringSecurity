package com.lpu.SpringSecurityDbAuthentication.service;

import com.lpu.SpringSecurityDbAuthentication.entity.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.awt.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class JWTService {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long tokenExpireTime;


    public String generateJwtToken(Employee employee) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", employee.getId());
        claims.put("role", employee.getRole());

        return Jwts.builder()
                .claims(claims)
                .subject(employee.getName())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + tokenExpireTime))
                .signWith(getKey())
                .compact();


    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
