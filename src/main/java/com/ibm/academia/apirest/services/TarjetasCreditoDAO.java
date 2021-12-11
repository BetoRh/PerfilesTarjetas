package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.TarjetasCredito;

public interface TarjetasCreditoDAO extends GenericoDAO<TarjetasCredito>{

	
	public TarjetasCredito actualizar(TarjetasCredito tarjetaEncontrada, TarjetasCredito tarjeta);
}
