package com.cibertec.restaurante.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codreserva;
	@ManyToOne
	@JoinColumn(name = "codmesa")
	private Mesa codmesa;
	@ManyToOne
	@JoinColumn(name = "codigoso")
	private Socio codigoso;
	@ManyToOne
	@JoinColumn(name = "codigopro")
	private Platillos codigopro;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechareserva;
	
	private String comentario;
	
	
	public Long getCodreserva() {
		return codreserva;
	}
	public void setCodreserva(Long codreserva) {
		this.codreserva = codreserva;
	}
	public Mesa getCodmesa() {
		return codmesa;
	}
	public void setCodmesa(Mesa codmesa) {
		this.codmesa = codmesa;
	}
	public Socio getCodigoso() {
		return codigoso;
	}
	public void setCodigoso(Socio codigoso) {
		this.codigoso = codigoso;
	}
	public Platillos getCodigopro() {
		return codigopro;
	}
	public void setCodigopro(Platillos codigopro) {
		this.codigopro = codigopro;
	}
	public Date getFechareserva() {
		return fechareserva;
	}
	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	

}
