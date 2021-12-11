package com.ibm.academia.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ibm.academia.apirest.models.entities.Persona;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
