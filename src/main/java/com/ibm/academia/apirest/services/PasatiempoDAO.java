package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Pasatiempo;

public interface PasatiempoDAO {
	
	public Iterable<Pasatiempo>findPasatiempoByNombre(String nombre);
	
	public String shopping(Integer edad, Double sueldo);
	
	public String travels(Integer edad, Double sueldo);
	
	public String help(Integer edad, Double sueldo);
	
	public String bussines(Integer edad, Double sueldo);
	
	public String sports(Integer edad, Double sueldo);
	
	public String myStyle(Integer edad, Double sueldo);
	
	

}
