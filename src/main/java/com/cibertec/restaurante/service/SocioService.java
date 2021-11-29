package com.cibertec.restaurante.service;
import java.util.List;

import com.cibertec.restaurante.entity.Socio;

public interface SocioService {
	
	public abstract List<Socio> listaSocio();
	public abstract Socio insertaActualizaSocio(Socio obj);
	public abstract List<Socio> listarPorNombresoLike(String nombreso);
	public abstract List<Socio> listarPorEstadoLike(int estadoso);	

}
