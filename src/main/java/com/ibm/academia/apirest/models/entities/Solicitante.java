package com.ibm.academia.apirest.models.entities;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "solicitantes",schema = "tarjeta")
//@Table(name = "solicitantes")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Solicitante extends Persona{
	
	@Column(name = "sueldo")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private BigDecimal sueldo;
	
	
	
	public Solicitante(Integer id, String nombre, String apellido, Integer edad, Direccion direccion, BigDecimal sueldo) {
		super(id, nombre, apellido, edad, direccion);
		this.sueldo = sueldo;
		
	}
	
	@ManyToMany(mappedBy = "solicitantes", fetch = FetchType.LAZY)
	private Set<TarjetasCredito> tarjetasCredito;
	
	@ManyToMany(mappedBy = "solicitantes", fetch = FetchType.LAZY)
	private Set<Pasatiempo> pasatiempos;
	
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sueldo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitante other = (Solicitante) obj;
		return Objects.equals(sueldo, other.sueldo);
	}
	
	
	@Override
	public String toString() {
		return "Solicitante [sueldo=" + sueldo + "]";
	}







	private static final long serialVersionUID = 470999926135066928L;

}
