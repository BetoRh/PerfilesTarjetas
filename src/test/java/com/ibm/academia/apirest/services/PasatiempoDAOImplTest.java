package com.ibm.academia.apirest.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Pasatiempo;
import com.ibm.academia.apirest.repositories.PasatiempoRepository;

public class PasatiempoDAOImplTest {
	
	PasatiempoDAO pasatiempoDAO;
	PasatiempoRepository pasatiempoRepository;
	
	@BeforeEach
	void setUp() {
		
		pasatiempoRepository = mock(PasatiempoRepository.class);
		pasatiempoDAO = new PasatiempoDAOImpl();
				
	}
	@Test
	@DisplayName("Test: Buscar pasatiempo por nombre")
	 void findPasatiempoByNombre() {
		 
		// Given
			String nombre = "Ingenieria";
			when(pasatiempoRepository.findPasatiempoByNombre(nombre))
					.thenReturn(Arrays.asList(DatosDummy.pasatiempo01()));

			// When
			Iterable<Pasatiempo> expected =  pasatiempoDAO.findPasatiempoByNombre(nombre);

			// Then
			assertThat(expected).isEqualTo(DatosDummy.pasatiempo01());
			

			verify(pasatiempoRepository).findPasatiempoByNombre(nombre);
		
		
	}

}
