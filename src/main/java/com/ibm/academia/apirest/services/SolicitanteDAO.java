package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Persona;

public interface SolicitanteDAO extends PersonaDAO {
	
	public Persona actualizar(Persona solicitanteEncontrado, Persona solicitante);

}
