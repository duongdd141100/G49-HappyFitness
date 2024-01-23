package com.example.happy_fitness.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.constants.Constants;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;

@Component
public class UserAuthProvider {
    @Autowired
    private AuthService authService;

    @Value("${application.secretKey}")
    private String secretKey;
    public Authentication validateUser(User user) {
        return new UsernamePasswordAuthenticationToken(authService.validateUser(user), null, Collections.emptyList());
    }

    public String createToken(String username) {
        try {
            Date now = new Date();
            Date expiry = new Date(now.getTime() + Constants.TOKEN_EXPIRE_MILLISECONDS);
            return JWT.create()
                    .withIssuer(username)
                    .withIssuedAt(now)
                    .withExpiresAt(expiry)
                    .sign(Algorithm.HMAC256(secretKey));
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageEnum.CREATE_TOKEN_FAILED.getCode());
        }
    }

    public Authentication validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return new UsernamePasswordAuthenticationToken(authService.findByUsername(decodedJWT.getIssuer()), null, Collections.emptyList());
    }
}
