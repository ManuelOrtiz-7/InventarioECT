package com.InventarioECT.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtils {

    @Value("${jwt.secret.key}")
    private String secretKey;
    @Value("${jwt.time.expiration}")
    private String timeExpiration;

    //Generar token de acceso
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    //Validar el token de acceso
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        } catch (Exception e) {
            log.error("Token invalido, error: ".concat(e.getMessage()));
            return false;
        }
    }

    //Obtener el username del token
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    //Obtener un solo claim
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = getClaimsFromToken(token);
        return claimsTFunction.apply(claims);
    }

    //Obtener todos los claims del token
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //Obtener la firma del token
    public Key getKey() {
        byte[] keyBytes =Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}



