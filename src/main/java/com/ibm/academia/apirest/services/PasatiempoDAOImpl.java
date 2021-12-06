package com.ibm.academia.apirest.services;

import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Pasatiempo;
import com.ibm.academia.apirest.repositories.PasatiempoRepository;

@Service
public class PasatiempoDAOImpl extends GenericoDAOImpl<Pasatiempo, PasatiempoRepository>  implements PasatiempoDAO{

	public PasatiempoDAOImpl(PasatiempoRepository repository) {
		
		super(repository);
	
	}

	

}
