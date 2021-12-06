package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "pasatiempos", schema = "tarjeta")
public class Pasatiempo implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", unique = true, nullable = false)
	private String nombre;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;
	
	
	
	public Pasatiempo(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "tarjetas_solicitantes_pasatiempos", schema = "tarjeta",
			joinColumns = @JoinColumn(name = "pasatiempo_id"),
			inverseJoinColumns = @JoinColumn ( name = "solicitante_id")
			)
	
	private Set<Solicitante> solicitantes;
	
	@OneToMany(mappedBy = "pasatiempo", fetch = FetchType.LAZY)
	private Set<TarjetasCredito> tarjetasCredito;
	
	
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
		Pasatiempo other = (Pasatiempo) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public String toString() {
		return "Pasatiempo [id=" + id + ", nombre=" + nombre + "]";
	}




	private static final long serialVersionUID = -6375338333435946811L;

}
