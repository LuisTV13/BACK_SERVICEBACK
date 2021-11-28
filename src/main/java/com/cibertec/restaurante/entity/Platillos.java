package com.cibertec.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "platillos")
public class Platillos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigopro;
	private String detallepro;
	private int stockpro;
	private double precioxunipro;
	
	
	public int getCodigopro() {
		return codigopro;
	}
	public void setCodigopro(int codigopro) {
		this.codigopro = codigopro;
	}
	public String getDetallepro() {
		return detallepro;
	}
	public void setDetallepro(String detallepro) {
		this.detallepro = detallepro;
	}
	public int getStockpro() {
		return stockpro;
	}
	public void setStockpro(int stockpro) {
		this.stockpro = stockpro;
	}
	public double getPrecioxunipro() {
		return precioxunipro;
	}
	public void setPrecioxunipro(double precioxunipro) {
		this.precioxunipro = precioxunipro;
	}
	
	
}
