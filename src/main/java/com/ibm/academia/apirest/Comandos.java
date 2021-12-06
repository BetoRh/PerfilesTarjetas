package com.ibm.academia.apirest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Solicitante;
import com.ibm.academia.apirest.services.PersonaDAO;
import com.ibm.academia.apirest.services.SolicitanteDAO;

@ComponentScan({"repositories", "services"})
public class Comandos implements CommandLineRunner{
	
	@Autowired
	@Qualifier("repositorioSolicitantes")
	private PersonaDAO personaDAO;
	
	@Autowired
	private SolicitanteDAO solicitanteDAO;

	@Override
	public void run(String... args) throws Exception {
		
		Direccion direccion = new Direccion("Pichirilo", "897", "56334", "18", "21", "Chimalhuacan");
		Persona persona = new Solicitante(null, "Jose", "Perez", 36, direccion, BigDecimal.valueOf(25578.00));
		solicitanteDAO.guardar(persona);
		
		
	}

}
