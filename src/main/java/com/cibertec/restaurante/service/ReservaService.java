package com.cibertec.restaurante.service;
import java.util.List;
import java.util.Optional;

import com.cibertec.restaurante.entity.Reserva;


public interface ReservaService {
	
	public abstract List<Reserva> listaReserva();
	public abstract Reserva insertaActualizaReserva(Reserva obj);
	public abstract List<Reserva> listarPorComentarioLike(String comentario);	

	
	public  void eliminarReserva(Long codreserva);
	
	
	public abstract Optional<Reserva> buscaPorId(Long codreserva);
}
