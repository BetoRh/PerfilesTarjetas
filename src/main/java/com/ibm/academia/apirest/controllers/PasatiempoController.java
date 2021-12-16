package com.ibm.academia.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;

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
	public String pasatiempos(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "edad") Integer edad,
			@RequestParam(value = "sueldo") Double sueldo) {
		
		
		if ((edad <= 17) || (sueldo <= 6999.00)) {

			throw new NotFoundException("No se cumple con la edad minima ni con el sueldo minimo");

		} else if (nombre.equalsIgnoreCase("Shopping")) {

			pasatiempo = pasatiempoDAO.shopping(edad, sueldo);
			
			 System.out.println(pasatiempo.toString());
			return pasatiempo;

		} else if (nombre.equalsIgnoreCase("Travels") || (nombre.equalsIgnoreCase("Help")) && sueldo <= 11999.00) {

			throw new NotFoundException("Debes de tener un sueldo mayor a 12000.00");

		} else if (nombre.equalsIgnoreCase("Travels")) {

			pasatiempo = pasatiempoDAO.travels(edad, sueldo);
			return pasatiempo;

		} else if (nombre.equalsIgnoreCase("Help")) {

			pasatiempo = pasatiempoDAO.help(edad, sueldo);
			return pasatiempo;

		} else if (nombre.equalsIgnoreCase("Bussines")) {

			pasatiempo = pasatiempoDAO.bussines(edad, sueldo);
			return pasatiempo;

		} else if (nombre.equalsIgnoreCase("Sport")) {

			pasatiempo = pasatiempoDAO.sports(edad, sueldo);
			return pasatiempo;

		} else if (nombre.equalsIgnoreCase("Style")) {

			pasatiempo = pasatiempoDAO.myStyle(edad, sueldo);
			return pasatiempo;

		}
		return null;
	}

}
