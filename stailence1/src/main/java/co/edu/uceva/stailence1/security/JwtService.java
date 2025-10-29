package co.edu.uceva.stailence1.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.edu.uceva.stailence1.model.entities.Usuarios;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

    private final String secret;
    private final long expirationMs;

    public JwtService(
            @Value("${app.jwt.secret}") String secret,
            @Value("${app.jwt.expiration-ms}") long expirationMs) {
        this.secret = secret;
        this.expirationMs = expirationMs;
    }

    public String generateToken(Usuarios usuario) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setClaims(Map.of(
                        "nombre", usuario.getNombre(),
                        "rol", usuario.getRol() != null ? usuario.getRol().name() : ""))
                .setSubject(usuario.getCorreo())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, String correo) {
        String username = extractCorreo(token);
        return username.equals(correo) && !isTokenExpired(token);
    }

    public String extractCorreo(String token) {
        return getAllClaims(token).getSubject();
    }

    private boolean isTokenExpired(String token) {
        return getAllClaims(token).getExpiration().before(new Date());
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
