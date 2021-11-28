package com.cibertec.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.restaurante.entity.Reserva;



public interface ReservaRepository  extends JpaRepository<Reserva, Long> {
	
	public abstract List<Reserva> findByComentarioLike(String comentario);
}
