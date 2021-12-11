package com.ibm.academia.apirest.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.ibm.academia.apirest.models.entities.Pasatiempo;
import com.ibm.academia.apirest.repositories.PasatiempoRepository;

@Service
public class PasatiempoDAOImpl extends GenericoDAOImpl<Pasatiempo, PasatiempoRepository>  implements PasatiempoDAO{

	public PasatiempoDAOImpl(PasatiempoRepository repository) {
		
		super(repository);
	
	}

	@Override
	@Transactional
	public Pasatiempo actualizar(Pasatiempo pasatiempoEncontrado, Pasatiempo pasatiempo) {
		
		Pasatiempo pasatiempoActualizado = null;
		pasatiempoEncontrado.setNombre(pasatiempo.getNombre());
		pasatiempoActualizado = repository.save(pasatiempoEncontrado);
		
		return pasatiempoActualizado;
	}
	
	

	

}
