package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Pasatiempo;

public interface PasatiempoDAO extends GenericoDAO<Pasatiempo> {
	
	public Pasatiempo actualizar(Pasatiempo pasatiempoEncontrado, Pasatiempo pasatiempo);

}
