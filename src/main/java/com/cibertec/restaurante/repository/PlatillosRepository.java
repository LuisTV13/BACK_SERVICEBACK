package com.cibertec.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.restaurante.entity.Platillos;

public interface PlatillosRepository extends JpaRepository<Platillos, Integer> {
	
	
	public abstract List<Platillos> findByDetalleproLike(String detallepro);
	
	

	
	
	

}
