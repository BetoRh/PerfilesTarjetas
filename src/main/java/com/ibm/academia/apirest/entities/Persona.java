package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "personas", schema = "tarjeta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 80, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 80, nullable = false)
	private String apellido;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;
	
	@Embedded
		@AttributeOverrides({
			@AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
			@AttributeOverride(name = "localidad", column = @Column(name = "localidad"))
		})
	private Direccion Direccion;
	
	
	
	public Persona(Integer id, String nombre, String apellido, Integer edad, Direccion direccion) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		Direccion = direccion;
	}
	
	@PrePersist
	private void antesPersistir() {
		
		this.fechaAlta = new Date();
	}
	
	@PreUpdate
	private void antesActualizar() {
		
		this.fechaActualizacion = new Date();
	}
	
	



	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}





	private static final long serialVersionUID = 7435045832876635940L;

}
