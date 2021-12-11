package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exception.handler.NotFoundException;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.models.entities.Solicitante;
import com.ibm.academia.apirest.services.PersonaDAO;
import com.ibm.academia.apirest.services.SolicitanteDAO;


@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {
	
	@Autowired
	@Qualifier("solicitanteDAOImpl")
	private PersonaDAO solicitanteDAO;
	/**
	 * Endpoint para Insertar nuevos Solicitantes
	 * @param solicitante parametro para insertar registros en bd
	 * @return Retorna el registro con datos insertados en bd
	 * @author JARA 10/12/2021
	 */
	@PostMapping
	  public ResponseEntity<?> crearSolicitante(@RequestBody Persona solicitante ){
	    
	    Persona solicitanteGuardado = solicitanteDAO.guardar(solicitante);
	    return new ResponseEntity<Persona>(solicitanteGuardado, HttpStatus.CREATED);
	  }
	  /**
	   * Endpoint para mostrar la lista de solicitantes en bd
	   * @return Regresa la lista de solicitantes en bd
	   * @NotFoundException En caso de que no se encuentren solicitantes en bd
	   * @author JARA 10/12/2021
	   */
	 @GetMapping("/solicitantes/lista")
	  public ResponseEntity<?> obtenerTodos() {
	    
	    List<Persona> solicitantes = (List<Persona>) solicitanteDAO.buscarTodos();
	    
	    if(solicitantes.isEmpty())
	      throw new NotFoundException("No existen solicitantes");
	    return new ResponseEntity<List<Persona>>(solicitantes, HttpStatus.OK);
	  }
	 /**
	   * Enpoint para buscar solicitantes por id
	   * @param solicitanteId Parametro para buscar los solicitantes
	   * @return Regresa el solicitante buscado 
	   * @NotFoundException En caso de que el solicitante con id no exista
	   * @author RIAJ 10/12/2021
	   */
	 @GetMapping("/solicitanteId/{solicitanteId}")
	    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer solicitanteId)
	    {
	        Optional<Persona> oSolicitante = solicitanteDAO.buscarPorId(solicitanteId);
	        
	        if(!oSolicitante.isPresent()) 
	            throw new NotFoundException(String.format("Alumno con id %d no existe", solicitanteId));
	        
	        return new ResponseEntity<Persona>(oSolicitante.get(), HttpStatus.OK);
	    }
	 
	 /**
	   * Endpoint para actualizar Solicitante en bd
	   * @param solicitanteId Parametro para buscar el Solicitante
	   * @param solicitante Parametro para actualizar el registro
	   * @return Retorna el solicitante ya actualizado
	   * @NotFoundException En caso de que el Solicitante con id no exista
	   * @author RAJA 10/12/2021
	   */
	 
	 @PutMapping("/upd/solicitanteId/{solicitanteId}")
	  public ResponseEntity<?> actualizarSolicitante(@PathVariable Integer solicitanteId, @RequestBody Persona solicitante) {
	    Optional<Persona> oSolicitante = solicitanteDAO.buscarPorId(solicitanteId);
	    
	    if(!oSolicitante.isPresent())
	      throw new NotFoundException(String.format("El solicitante con ID %d no existe", solicitanteId));
	    
	    Persona solicitanteActualizado = ((SolicitanteDAO)solicitanteDAO).actualizar(oSolicitante.get(), solicitante);
	    return new ResponseEntity<Persona>(solicitanteActualizado, HttpStatus.OK);
	  }
	 /**
	  * Endpoint para eliminar Solicitantes
	   * @param solicitanteId Parametro para buscar el registro
	   * @return Retorna mensaje con id del Solicitante eliminado
	   * @NotFoundException En caso de que el Solicitante con id no exista
	   * @author RAJA 10/12/2021
	   */
	
	  @DeleteMapping("/solicitanteId/{solicitanteId}")
	  public ResponseEntity<?> eliminarAlumno(@PathVariable Integer solicitanteId){
	    Optional<Persona> oSolicitante = solicitanteDAO.buscarPorId(solicitanteId);
	    
	    if(!oSolicitante.isPresent())
	      throw new NotFoundException(String.format("El solicitante con ID %d no existe", solicitanteId));
	    
	    solicitanteDAO.eliminarPorId(oSolicitante.get().getId()); 
	    
	    return new ResponseEntity<String>("Solicitante ID: " + solicitanteId + " se elimino satisfactoriamente",  HttpStatus.NO_CONTENT);
	  }
	 
	 

}
