package com.ibm.academia.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exception.BadRequestException;
import com.ibm.academia.apirest.exception.handler.NotFoundException;
import com.ibm.academia.apirest.models.entities.Pasatiempo;
import com.ibm.academia.apirest.models.entities.TarjetasCredito;
import com.ibm.academia.apirest.services.PasatiempoDAO;
import com.ibm.academia.apirest.services.TarjetasCreditoDAO;

@RestController
@RequestMapping("/tarjetas")
public class TarjetasController {
	
	Logger logger = LoggerFactory.getLogger(TarjetasController.class);
	

	
	@Autowired
	private TarjetasCreditoDAO tarjetasCreditoDAO;
	
	/**
	 * Enpoint para realizar el registro de nuevas Tarjetas de Credito
	 * @param carrera Parametro para ingresar la Tarjeta de Credito
	 * @param result parametro que atrapa posibles errores
	 * @return Regresa una nueva Tarjeta de credito ingresada
	 * @author JARA 10/12/09
	 */
	@PostMapping
	public ResponseEntity<?> guardarTarjeta(@Valid @RequestBody TarjetasCredito tarjetasCredito, BindingResult result){
		
		
		Map<String, Object> validaciones = new HashMap<String, Object>();
		if(result.hasErrors()) {
			List<String> listaErrores = result.getFieldErrors()
					.stream()
					.map(errores -> "Campo: '" + errores.getField() + "'  " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
			
		}
		TarjetasCredito tarjetaGuardada = tarjetasCreditoDAO.guardar(tarjetasCredito);
		
		return new ResponseEntity<TarjetasCredito>(tarjetaGuardada, HttpStatus.CREATED);
	}
	
	/**
	 * Endpoint que muestra la lista de Tarjetas de credito en bd
	 * @return Regresa la lista Tarjetas de credito
	 * @BadRequestException En caso de de que no encuentre ninguna tarjeta de credito
	 * @author JARA 10/12/2021
	 */
	@GetMapping("/lista/tarjetas")
	public List<TarjetasCredito> buscarTodas(){
		
		List<TarjetasCredito> tarjetas = (List<TarjetasCredito>) tarjetasCreditoDAO.buscarTodos();
		
		if(tarjetas.isEmpty())
			throw new BadRequestException("No existen tarjetas");
		return tarjetas;
	}
	
	/**
	 * Enpoint para buscar Tarjetas por id
	 * @param tarjetasId Parametro solicitado para realizar la busqueda de la Tarjeta
	 * @return Regresa la Tarjeta de acuerdo al id ingresado
	 * @BadRequestException En caso de que la Tarjeta no exista
	 * @author RAJA 10/12/2021
	 */
	
	@GetMapping("/id/{tarjetaId}")
	public TarjetasCredito buscarCarreraPorId(@PathVariable Integer tarjetaId) {
		
		Optional<TarjetasCredito> oTarjeta = tarjetasCreditoDAO.buscarPorId(tarjetaId);
		if(!oTarjeta.isPresent())
			throw new BadRequestException(String.format("La tarjeta con ID: %d no existe", tarjetaId));
			
		return oTarjeta.get();
	}
	
	/**
	 * Endpoint para actualizar un objeto de tipo Tarjeta
	 * @param tarjetaId Parametro para buscar la tarjeta
	 * @param tarjeta Objeto con la informacion a modificar
	 * @return Retorna un objeto de tipo Tarjeta con la informacion actualizada
	 * @NotFoundException En caso de que falle la actualizando el objeto tarjeta
	 * @author JARA - 10/12/2021
	 */
	 @PutMapping("/upd/tarjetaId/{tarjetaId}")
	  public ResponseEntity<?> actualizarTarjeta(@PathVariable Integer tarjetaId, @RequestBody TarjetasCredito tarjeta){
		 
	    Optional<TarjetasCredito> oTarjeta = tarjetasCreditoDAO.buscarPorId(tarjetaId);
	    
	    if(!oTarjeta.isPresent())
	      throw new NotFoundException(String.format("La tarjeta con ID: %d no existe", tarjetaId));
	    
	    TarjetasCredito tarjetaActualizada = tarjetasCreditoDAO.actualizar(oTarjeta.get(), tarjeta); 
	    
	    return new ResponseEntity<TarjetasCredito>(tarjetaActualizada, HttpStatus.OK); 
	  }
	 
	 /**
	  * Endpoint para eliminar Tarjetas
	  * @param tarjetaId Parametro solicitado para buscar la tarjeta
	  * @return Elimina el registro de la tarjeta
	  * @BadRequestException En caso de que la tarjeta no exista
	  */
	 
	 @DeleteMapping("/tarjetaId/{tarjetaId}")
	  public ResponseEntity<?> eliminarTarjeta(@PathVariable Integer tarjetaId){
	    Map<String, Object> respuesta = new HashMap<String, Object>();
	    
	    Optional<TarjetasCredito> tarjeta = tarjetasCreditoDAO.buscarPorId(tarjetaId);
	    
	    if(!tarjeta.isPresent())
	      throw new NotFoundException(String.format("La carrera con ID: %d no existe", tarjetaId));
	    
	    tarjetasCreditoDAO.eliminarPorId(tarjetaId);
	    respuesta.put("OK", "Tarjeta ID: " + tarjetaId + " eliminada exitosamente");
	    return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
	  }
	 

}
