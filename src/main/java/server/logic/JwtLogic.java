package server.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.JacksonDeserializer;
import io.jsonwebtoken.io.JacksonSerializer;
import io.jsonwebtoken.security.Keys;
import server.responses.VerifyResponse;


import java.security.Key;
import java.util.Date;

public class JwtLogic {
    private ObjectMapper objectMapper;
    private Key key;

    public JwtLogic(ObjectMapper objectmapper, String secret)
    {
        this.key  = Keys.hmacShaKeyFor(secret.getBytes());
        this.objectMapper = objectmapper;
    }

    public String generateJwt(int id,String email)
    {
        return Jwts.builder()
                .serializeToJsonWith(new JacksonSerializer<>(this.objectMapper))
                .claim("id", id)
                .claim("email", email)
                .setExpiration(new Date(System.currentTimeMillis() + (7200*1000)))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(this.key, SignatureAlgorithm.HS256)
                .compact();
    }

    public VerifyResponse verify(String token)
    {
         Jws<Claims> claims = Jwts.parser()
                .deserializeJsonWith(new JacksonDeserializer<>(this.objectMapper))
                .setSigningKey(this.key)
                .parseClaimsJws(token);
         int id = claims.getBody().get("id", Integer.class);
         String email = claims.getBody().get("email", String.class);
         return new VerifyResponse(id,email);
    }
}
