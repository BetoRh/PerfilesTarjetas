package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO {

	public PersonaDAOImpl(PersonaRepository repository) {
		
		super(repository);
		
	}

}
