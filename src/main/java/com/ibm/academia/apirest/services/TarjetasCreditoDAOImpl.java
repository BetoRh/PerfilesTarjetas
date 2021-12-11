package com.ibm.academia.apirest.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.models.entities.TarjetasCredito;
import com.ibm.academia.apirest.repositories.TarjetasCreditoRepository;

@Service
public class TarjetasCreditoDAOImpl extends GenericoDAOImpl<TarjetasCredito, TarjetasCreditoRepository> implements TarjetasCreditoDAO {

	public TarjetasCreditoDAOImpl(TarjetasCreditoRepository repository) {
		
		super(repository);
		
	}

	@Override
	@Transactional
	public TarjetasCredito actualizar(TarjetasCredito tarjetaEncontrada, TarjetasCredito tarjeta) {
		TarjetasCredito tarjetaActualizada = null;
		tarjetaEncontrada.setNombre(tarjeta.getNombre());
		tarjetaActualizada = repository.save(tarjetaEncontrada);
		return tarjetaActualizada;
	}

}
