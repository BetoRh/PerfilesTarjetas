package com.ibm.academia.apirest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.models.entities.Pasatiempo;

@Repository
public interface PasatiempoRepository extends CrudRepository<Pasatiempo, Integer> {
	
	@Query("select p.nombre from Pasatiempo p where p.nombre = ?1")
	public Iterable<Pasatiempo>findPasatiempoByNombre(String nombre);
	


}
