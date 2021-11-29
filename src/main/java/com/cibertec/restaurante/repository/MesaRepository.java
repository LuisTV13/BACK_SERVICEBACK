package com.cibertec.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.restaurante.entity.Mesa;



public interface MesaRepository  extends JpaRepository<Mesa, Integer> {
	
	public abstract List<Mesa> findByDescmesaLike(String descmesa);
	
	public abstract List<Mesa> findByIdtipoestLike(int idtipoest);
}
