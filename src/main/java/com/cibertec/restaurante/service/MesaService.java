package com.cibertec.restaurante.service;
import java.util.List;

import com.cibertec.restaurante.entity.Mesa;

public interface MesaService  {

	public abstract List<Mesa> listaMesa();
	public abstract Mesa insertaActualizaMesa(Mesa obj);
	public abstract List<Mesa> listarPorDescmesaLike(String descmesa);	
	public abstract List<Mesa> listarPorIdtipoestLike(int idtipoest);	
}
