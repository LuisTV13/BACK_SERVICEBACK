package com.cibertec.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "socio")
public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoso;
	private String nombreso;
	private String apellidoso;
	private String dniso;
	private String telefonoso;
	private int estadoso;
	
	public int getCodigoso() {
		return codigoso;
	}
	public void setCodigoso(int codigoso) {
		this.codigoso = codigoso;
	}
	public String getNombreso() {
		return nombreso;
	}
	public void setNombreso(String nombreso) {
		this.nombreso = nombreso;
	}
	public String getApellidoso() {
		return apellidoso;
	}
	public void setApellidoso(String apellidoso) {
		this.apellidoso = apellidoso;
	}
	public String getDniso() {
		return dniso;
	}
	public void setDniso(String dniso) {
		this.dniso = dniso;
	}
	public String getTelefonoso() {
		return telefonoso;
	}
	public void setTelefonoso(String telefonoso) {
		this.telefonoso = telefonoso;
	}
	public int getEstadoso() {
		return estadoso;
	}
	public void setEstadoso(int estadoso) {
		this.estadoso = estadoso;
	}
	
	
	
	
	
	
	
	
	

}
