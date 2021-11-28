package com.cibertec.restaurante.service;

import java.util.List;

import com.cibertec.restaurante.entity.Platillos;

public interface PlatilloService   {
	
	public abstract List<Platillos> listaPlatillos();
	public abstract Platillos insertaActualizaPlatillos(Platillos obj);
	public abstract List<Platillos> listarPorDetalleproLike(String detallepro);	

	
	

}
