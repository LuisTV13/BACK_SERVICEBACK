package com.cibertec.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codmesa;
	private String descmesa;
	private int capacidad;
	private int idtipoest;
	
	
	public int getCodmesa() {
		return codmesa;
	}
	public void setCodmesa(int codmesa) {
		this.codmesa = codmesa;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getIdtipoest() {
		return idtipoest;
	}
	public void setIdtipoest(int idtipoest) {
		this.idtipoest = idtipoest;
	}
	public String getDescmesa() {
		return descmesa;
	}
	public void setDescmesa(String descmesa) {
		this.descmesa = descmesa;
	}
	
	
	
	
}
