package com.ibm.academia.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import com.ibm.academia.apirest.services.PasatiempoDAO;

@RestController
@RequestMapping("/pasatiempo")
public class PasatiempoController {
	
	@Autowired
	private PasatiempoDAO pasatiempoDAO;
	
	/**
	 * Endpoint para Insertar nuevos Pasatiempos
	 * @param pasatiempo Parametro para insertar registros en bd
	 * @return Retorna el registro con datos insertados en bd
	 * @author JARA 10/12/2021
	 */
	@PostMapping
	public ResponseEntity<?> guardarPasatiempo(@Valid @RequestBody Pasatiempo pasatiempo, BindingResult result){
		
		Map<String, Object> validaciones = new HashMap<String, Object>();
		if(result.hasErrors()) {
			List<String> listaErrores = result.getFieldErrors()
					.stream()
					.map(errores -> "Campo: '" + errores.getField() + "'  " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista Errores", listaErrores);
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
			
		}
		
		Pasatiempo pasatiempoGuardado = pasatiempoDAO.guardar(pasatiempo);
		
		return new ResponseEntity<Pasatiempo>(pasatiempoGuardado, HttpStatus.CREATED);
		
	}
	
	/**
	 * Endpoint que muestra la lista de pasatiempos en bd
	 * @return Regresa la lista Pasatiempos
	 * @BadRequestException En caso de de que no encuentre ningun pasatiempo
	 * @author JARA 10/12/2021
	 */
	
	@GetMapping("/lista/pasatiempos")
	public List<Pasatiempo> buscarTodos(){
		
		List<Pasatiempo> pasatiempos = (List<Pasatiempo>) pasatiempoDAO.buscarTodos();
		
		if(pasatiempos.isEmpty())
			throw new BadRequestException("No existen pasatiempos");
		return pasatiempos;
	}
	
	/**
	 * Enpoint para buscar pasatiempos por id
	 * @param pasatiempoId Parametro solicitado para realizar la busqueda de Carrera
	 * @return Regresa el Pasatiempo de acuerdo al id ingresado
	 * @BadRequestException En caso de que el pasatiempo no exista
	 * @author RAJA 10/12/2021
	 */
	@GetMapping("/id/{pasatiempoId}")
	public Pasatiempo buscarCarreraPorId(@PathVariable Integer pasatiempoId) {
		
		Optional<Pasatiempo> oPasatiempo = pasatiempoDAO.buscarPorId(pasatiempoId);
		if(!oPasatiempo.isPresent())
			throw new BadRequestException(String.format("El pasatiempo con ID: %d no existe", pasatiempoId));
			
		return oPasatiempo.get();
	}
	
	/**
	 * Endpoint para actualizar un objeto de tipo pasatiempo
	 * @param carreraId Parametro para buscar la pasatiempo
	 * @param carrera Objeto con la informacion a modificar
	 * @return Retorna un objeto de tipo Pasatiempo con la informacion actualizada
	 * @NotFoundException En caso de que falle la actualizando el objeto pasatiempo
	 * @author JARA - 10/12/2021
	 */
	 @PutMapping("/upd/pasatiempoId/{pasatiempoId}")
	  public ResponseEntity<?> actualizarCarrera(@PathVariable Integer pasatiempoId, @RequestBody Pasatiempo pasatiempo){
		 
	    Optional<Pasatiempo> oPasatiempo = pasatiempoDAO.buscarPorId(pasatiempoId);
	    
	    if(!oPasatiempo.isPresent())
	      throw new NotFoundException(String.format("El pasatiempo con ID: %d no existe", pasatiempoId));
	    
	    Pasatiempo pasatiempoActualizado = pasatiempoDAO.actualizar(oPasatiempo.get(), pasatiempo); 
	    
	    return new ResponseEntity<Pasatiempo>(pasatiempoActualizado, HttpStatus.OK); 
	  }
	 
	 /**
	  * Endpoint para eliminar Pasatiempos
	  * @param pasatiempoId Parametro solicitado para buscar el pasatiempo
	  * @return Elimina el registro del pasatiempo
	  * @BadRequestException En caso de que el pasatiempo no exista
	  */
	 
	 @DeleteMapping("/pasatiempoId/{pasatiempoId}")
	  public ResponseEntity<?> eliminarPasatiempo(@PathVariable Integer pasatiempoId){
	    Map<String, Object> respuesta = new HashMap<String, Object>();
	    
	    Optional<Pasatiempo> pasatiempo = pasatiempoDAO.buscarPorId(pasatiempoId);
	    
	    if(!pasatiempo.isPresent())
	      throw new NotFoundException(String.format("El pasatiempo con ID: %d no existe", pasatiempoId));
	    
	    pasatiempoDAO.eliminarPorId(pasatiempoId);
	    respuesta.put("OK", "Pasatiempo ID: " + pasatiempoId + " eliminado exitosamente");
	    return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
	  }

}
