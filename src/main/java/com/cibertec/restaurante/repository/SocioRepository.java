package com.cibertec.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.restaurante.entity.Socio;

public interface SocioRepository   extends JpaRepository<Socio, Integer>{
	
	
	public abstract List<Socio> findByNombresoLike(String nombreso);
	
	

}
