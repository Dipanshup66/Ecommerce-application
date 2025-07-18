package com.dipanshu.auth_service.auth.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {
	// private final String secret = "mySecretKey"; // strong key rakhna prod me
	@Value("${jwt.secret}")
	private String secret;
	private final long expirationMs = 24 * 60 * 60 * 1000; // 1 din

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expirationMs))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
}
