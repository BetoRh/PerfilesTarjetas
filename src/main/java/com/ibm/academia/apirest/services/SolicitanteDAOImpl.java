package com.ibm.academia.apirest.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;

@Service
public class SolicitanteDAOImpl extends PersonaDAOImpl implements SolicitanteDAO{

	public SolicitanteDAOImpl(@Qualifier("repositorioSolicitantes") PersonaRepository repository) {
		
		super(repository);
		
	}

	@Override
	@Transactional
	public Persona actualizar(Persona solicitanteEncontrado, Persona solicitante) {
		
		Persona solicitanteActualizado = null;
		solicitanteEncontrado.setNombre(solicitante.getNombre());
		solicitanteEncontrado.setApellido(solicitante.getApellido());
		solicitanteEncontrado.setEdad(solicitante.getEdad());
		solicitanteEncontrado.setDireccion(solicitante.getDireccion());
		solicitanteActualizado = repository.save(solicitanteEncontrado);
		return solicitanteActualizado;
	}

}
