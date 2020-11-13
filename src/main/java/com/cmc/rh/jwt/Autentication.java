package com.cmc.rh.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


public class Autentication {
	
	@Autowired
	Environment env;
				
	
	public String encript(String nombre, String pass) {
		try {
			if(nombre.equalsIgnoreCase("SIS") && pass.equalsIgnoreCase("*Abcd1234")) {
			    Algorithm algorithm = Algorithm.HMAC256(env.getProperty("com.grf.key"));
			    String token = JWT.create()
			        .withIssuer("auth0")
			        .withClaim("nombre", nombre)
			        .withClaim("perfil", "PRUEBA")
			        .sign(algorithm);
			    return token;	
			}else {
				return null;
			}
		} catch (JWTCreationException exception){
		    System.out.println("Error al genetar token");
           return null;
		}
	}
	
	
	public boolean desCript(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(env.getProperty("com.grf.key"));
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("auth0")
		        .build(); 
		       DecodedJWT jwt = verifier.verify(token);
		       return true;
		} catch (JWTVerificationException exception){
		  return false;
		}
	}
	

}
