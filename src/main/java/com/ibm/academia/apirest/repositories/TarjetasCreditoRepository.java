package com.ibm.academia.apirest.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.models.entities.TarjetasCredito;

@Repository
public interface TarjetasCreditoRepository extends CrudRepository<TarjetasCredito, Integer> {
	

}
