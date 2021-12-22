package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exception.handler.NotFoundException;
import com.ibm.academia.apirest.models.entities.Pasatiempo;
import com.ibm.academia.apirest.services.PasatiempoDAO;

@RestController
@RequestMapping("/pasatiempo")
public class PasatiempoController {

	@Autowired
	private PasatiempoDAO pasatiempoDAO;

	String pasatiempo;
	
	/**
	 * Endpoint para realizar la consulta de tipos de tarjetas
	 * @param nombre parametro utilizado para validar el pasatiempo ingresado
	 * @param edad	 parametro utilizado para validar la edad ingresada
	 * @param sueldo parametro utilizado para validar el sueldo ingresado
	 * @NotFoundException En caso de que algun parametro no se cumpla
	 * @return retorna los tipos de tarjetas de acuerdo a los parametros ingresados
	 * @author RAJA 15/12/10
	 */
	
	
	@GetMapping("/validar")
	public ResponseEntity<?> pasatiempos(@RequestParam(value = "pasatiempo") String pasatiempo, @RequestParam(value = "edad") Integer edad,
			@RequestParam(value = "sueldo") Double sueldo) {
		
		String oPasatiempo =  pasatiempoDAO.validacion(pasatiempo, edad, sueldo);
		
		return new ResponseEntity<String>(oPasatiempo, HttpStatus.OK);
		 
	}
	
	

}
