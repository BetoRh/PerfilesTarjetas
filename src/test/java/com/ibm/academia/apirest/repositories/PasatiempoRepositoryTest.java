package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Pasatiempo;

@DataJpaTest
public class PasatiempoRepositoryTest {
	
	@Autowired
	private PasatiempoRepository pasatiempoRepository;
	
	@BeforeEach
	void setUp() {
		
		pasatiempoRepository.save(DatosDummy.pasatiempo01());
		pasatiempoRepository.save(DatosDummy.pasatiempo02());
		pasatiempoRepository.save(DatosDummy.pasatiempo03());
		pasatiempoRepository.save(DatosDummy.pasatiempo04());
		pasatiempoRepository.save(DatosDummy.pasatiempo05());
		pasatiempoRepository.save(DatosDummy.pasatiempo06());
	}
	
	@AfterEach
	void tearDown() {
		
		pasatiempoRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar pasatiempo por nombre")
	void findPasatiempoByNombre() {
		
		//Given
		
	
		//When
		
		Iterable<Pasatiempo> expected = pasatiempoRepository.findPasatiempoByNombre("Shopping"); 
		
		//Then
		
		assertThat(((List<Pasatiempo>)expected).size() == 1).isTrue();
		
		
	}
	

}
