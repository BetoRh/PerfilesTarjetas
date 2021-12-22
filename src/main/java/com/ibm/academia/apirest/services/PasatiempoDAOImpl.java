package com.ibm.academia.apirest.services;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.enums.TiposTarjetas;
import com.ibm.academia.apirest.exception.handler.NotFoundException;
import com.ibm.academia.apirest.models.entities.Pasatiempo;
import com.ibm.academia.apirest.repositories.PasatiempoRepository;

@Service
public class PasatiempoDAOImpl implements PasatiempoDAO {
	
	@Autowired
	private PasatiempoRepository pasatiempoRepository;

	
	String respuesta;
	

	@Override
	@Transactional(readOnly = true)
	public String shopping(Integer edad, Double sueldo) {

		if ((edad >= 18 && edad <= 23) && (sueldo >= 7000.00 && sueldo <= 14999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.AFINITY_CARD);

		}
		if ((edad >= 24 && edad <= 32) && (sueldo >= 7000.00 && sueldo <= 14999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.CLASICA + "\n"
					+ TiposTarjetas.AFINITY_CARD + "\n" + TiposTarjetas.OFFICE_DEPOT + "\n" + TiposTarjetas.COSTCO
					+ "\n" + TiposTarjetas.BEST_BUY + "\n" + TiposTarjetas.HOME_DEPOT);

		}
		if ((edad >= 33 && edad <= 75) && (sueldo >= 7000.00 && sueldo <= 14999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.CLASICA + "\n" + TiposTarjetas.OFFICE_DEPOT + "\n" + TiposTarjetas.COSTCO
					+ "\n" +TiposTarjetas.BEST_BUY + "\n" + TiposTarjetas.HOME_DEPOT);

		} else if ((edad >= 18 && edad <= 23) && (sueldo >= 15000.00 && sueldo <= 34999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.AFINITY_CARD);

		}
		if ((edad >= 24 && edad <= 32) && (sueldo >= 15000.00 && sueldo <= 34999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.ORO + "\n" + TiposTarjetas.AFINITY_CARD + "\n"
					+ TiposTarjetas.OFFICE_DEPOT + "\n" + TiposTarjetas.COSTCO + "\n" + TiposTarjetas.BEST_BUY + "\n"
					+ TiposTarjetas.HOME_DEPOT);

		}
		if ((edad >= 33 && edad <= 75) && (sueldo >= 15000.00 && sueldo <= 34999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.ORO + "\n" + TiposTarjetas.OFFICE_DEPOT + "\n" + TiposTarjetas.COSTCO
					+ "\n" + TiposTarjetas.BEST_BUY + "\n" + TiposTarjetas.HOME_DEPOT);

		} else if ((edad >= 18 && edad <= 23) && (sueldo >= 35000.00 && sueldo <= 49999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.AFINITY_CARD);

		}
		if ((edad >= 24 && edad <= 75) && (sueldo >= 35000.00 && sueldo <= 49999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.PLATINUM + "\n" + TiposTarjetas.OFFICE_DEPOT + "\n"
					+ TiposTarjetas.COSTCO + "\n" + TiposTarjetas.BEST_BUY + "\n" + TiposTarjetas.HOME_DEPOT);

		} else if ((edad >= 18 && edad <= 23) && (sueldo >= 50000.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.AFINITY_CARD);

		}
		if ((edad >= 24 && edad <= 75) && (sueldo >= 50000.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.PLATINUM);

		}
		return respuesta;

	}

	@Override
	@Transactional
	public String travels(Integer edad, Double sueldo) {

		if ((edad >= 18 && edad <= 75) && (sueldo >= 12000.00 && sueldo <= 29999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.CITI + "\n" + TiposTarjetas.AADVANTAGE);

		} else if ((edad >= 18 && edad <= 23) && (sueldo >= 30000.00 && sueldo <= 34999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.CITI + "\n" + TiposTarjetas.AADVANTAGE);

		}
		if ((edad >= 24 && edad <= 75) && (sueldo >= 30000.00 && sueldo <= 34999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.CITI + "\n" + TiposTarjetas.AADVANTAGE + "\n"
					+ TiposTarjetas.PLATINUM);

		} else if ((edad >= 18 && edad <= 23) && (sueldo >= 35000.00 && sueldo <= 49999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.CITI + "\n" + TiposTarjetas.AADVANTAGE);

		}
		if ((edad >= 24 && edad <= 75) && (sueldo >= 30000.00 && sueldo <= 34999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.CITI + "\n" + TiposTarjetas.AADVANTAGE + "\n"
					+ TiposTarjetas.PLATINUM);

		} else if ((edad >= 18 && edad <= 22) && (sueldo >= 50000.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.CITI + "\n" + TiposTarjetas.AADVANTAGE);

		}
		if ((edad >= 23 && edad <= 75) && (sueldo >= 50000.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.PLATINUM);
		}

		return respuesta;
	}

	@Override
	@Transactional
	public String help(Integer edad, Double sueldo) {

		if ((edad >= 18 && edad <= 75) && (sueldo >= 12000.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.TELETON + "\n" + TiposTarjetas.APAC);
		}

		return respuesta;
		

	}

	@Override
	@Transactional
	public String bussines(Integer edad, Double sueldo) {

		if ((edad >= 18 && edad <= 75) && (sueldo >= 7000.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.OFFICE_DEPOT + "\n" + TiposTarjetas.COSTCO + "\n" + TiposTarjetas.BEST_BUY + "\n" + TiposTarjetas.HOME_DEPOT);
		}

		return respuesta;

	}
	
	@Override
	@Transactional
	public String sports(Integer edad, Double sueldo) {
		
		if ((edad >= 18 && edad <= 75) && (sueldo >= 12000.00 && sueldo <= 34999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.MARTI_CLASICA + "\n" + TiposTarjetas.AMERICA_DEPORTEISMO + "\n"
					+ TiposTarjetas.PUMAS_DEPORTEISMO + "\n" + TiposTarjetas.TOLUCA_DEPORTEISMO + "\n" + TiposTarjetas.LAVERDE_DEPORTEISMO);
		
		}else if ((edad >= 18 && edad <= 75) && (sueldo >= 35000.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.MARTI_PREMIUM);
		}
		
		return respuesta;
		
		
	}
	
	@Override
	@Transactional
	public String myStyle(Integer edad, Double sueldo) {
		
		if ((edad >= 18 && edad <= 32) && (sueldo >= 7000.00 && sueldo <= 14999.00)) {

			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.AFINITY_CARD);

		}if ((edad >= 33 && edad <= 75) && (sueldo >= 7000.00 && sueldo <= 14999.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART);
		
		}else if ((edad >= 18 && edad <= 23) && (sueldo >= 15000.00 && sueldo <= 29999.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.AFINITY_CARD);
			
		}if ((edad >= 24 && edad <= 32) && (sueldo >= 15000.00 && sueldo <= 29999.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.ORO + "\n" + TiposTarjetas.AFINITY_CARD);
			
		}if ((edad >= 33 && edad <= 75) && (sueldo >= 15000.00 && sueldo <= 29999.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.ORO);	
			
		}else if ((edad >= 18 && edad <= 23) && (sueldo >= 30000.00 && sueldo <= 34999.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.AFINITY_CARD);
			
		}if ((edad >= 24 && edad <= 32) && (sueldo >= 30000.00 && sueldo <= 34999.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.PLATINUM + "\n" + TiposTarjetas.AFINITY_CARD);
			
		}if ((edad >= 33 && edad <= 75) && (sueldo >= 15000.00 && sueldo <= 29999.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.PLATINUM);	
		
		}else if ((edad >= 18 && edad <= 23) && (sueldo >= 35000.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART);
			
		}if ((edad >= 24 && edad <= 75) && (sueldo >= 35000.00)) {
			
			respuesta = ("Tarjeta: " + TiposTarjetas.BSMART + "\n" + TiposTarjetas.PLATINUM);
			
		}
		
		
		return respuesta;
		
	}

	@Override
	@Transactional
	public Iterable<Pasatiempo> findPasatiempoByNombre(String nombre) {
		
		
		
		return pasatiempoRepository.findPasatiempoByNombre(nombre);
	
	
	}
	
	public String validacion(String nombre, Integer edad, Double sueldo) {
		
		String respuesta;
	
		if ((edad <= 17) || (sueldo <= 6999.00)) {

			throw new NotFoundException("No se cumple con la edad minima ni con el sueldo minimo");

		} else if (nombre.equalsIgnoreCase("Shopping")) {

			respuesta = shopping(edad, sueldo);
			
			 System.out.println(respuesta.toString());
			return  respuesta;

		} else if (nombre.equalsIgnoreCase("Travels") && (nombre.equalsIgnoreCase("Help")) && sueldo <= 11999.00) {

			throw new NotFoundException("Debes de tener un sueldo mayor a 12000.00");

		} else if (nombre.equalsIgnoreCase("Travels")) {

			respuesta = travels(edad, sueldo);
			return respuesta;

		} else if (nombre.equalsIgnoreCase("Help")) {

			respuesta = help(edad, sueldo);
			return respuesta;

		} else if (nombre.equalsIgnoreCase("Bussines")) {

			respuesta = bussines(edad, sueldo);
			return respuesta;

		} else if (nombre.equalsIgnoreCase("Sport")) {

			respuesta = sports(edad, sueldo);
			return respuesta;

		} else if (nombre.equalsIgnoreCase("Style")) {

			respuesta = myStyle(edad, sueldo);
			return respuesta;

		}
		 throw new NotFoundException("Debes de introducir un pasatiempo valido");
	}
	}


