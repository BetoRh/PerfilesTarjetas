package com.ibm.academia.apirest.services;

import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.TarjetasCredito;
import com.ibm.academia.apirest.repositories.TarjetasCreditoRepository;

@Service
public class TarjetasCreditoDAOImpl extends GenericoDAOImpl<TarjetasCredito, TarjetasCreditoRepository> implements TarjetasCreditoDAO {

	public TarjetasCreditoDAOImpl(TarjetasCreditoRepository repository) {
		
		super(repository);
		
	}

}
