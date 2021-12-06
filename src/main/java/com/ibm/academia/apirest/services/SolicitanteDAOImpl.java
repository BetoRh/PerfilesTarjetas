package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.repositories.PersonaRepository;

@Service
public class SolicitanteDAOImpl extends PersonaDAOImpl implements PersonaDAO{

	public SolicitanteDAOImpl(@Qualifier("repositorioSolicitantes") PersonaRepository repository) {
		
		super(repository);
		
	}

}
