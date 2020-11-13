package com.cmc.rh.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.rh.jwt.Autentication;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/aut")
public class AuetnticateUser {

	@Autowired
	Autentication autentication;
	@ApiOperation(value = "Autenticacion ", response = Iterable.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 204, message = "No se encotraron registro"),
	    @ApiResponse(code = 401, message = "No estás autorizado para ver el recurso."),
	    @ApiResponse(code = 403, message = "Está prohibido acceder al recurso al que intentabas acceder"),
	    @ApiResponse(code = 404, message = "El recurso que intentabas alcanzar no se encuentra  ")
	})
	@PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<Object>  autenticar(  String usuario , String password ) {
		if(usuario != null && password != null) {
			String token= autentication.encript(usuario, password);
			if(token != null) {
				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", token);
				return new ResponseEntity<>(headers, HttpStatus.OK);
			}else {
				return new ResponseEntity<>( HttpStatus.FORBIDDEN);
			}
		}else {
			return new ResponseEntity<>( HttpStatus.FORBIDDEN);
		}
	}
	
}
