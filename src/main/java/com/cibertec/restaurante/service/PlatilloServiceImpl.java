package com.cibertec.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.restaurante.entity.Platillos;
import com.cibertec.restaurante.repository.PlatillosRepository;

@Service
public class PlatilloServiceImpl implements PlatilloService {
	
	@Autowired
	private PlatillosRepository platillorepo;

	@Override
	public List<Platillos> listaPlatillos() {
		// TODO Auto-generated method stub
		return platillorepo.findAll();
	}

	@Override
	public Platillos insertaActualizaPlatillos(Platillos obj) {
		// TODO Auto-generated method stub
		return platillorepo.save(obj);
	}

	@Override
	public List<Platillos> listarPorDetalleproLike(String detallepro) {
		// TODO Auto-generated method stub
		return platillorepo.findByDetalleproLike(detallepro);
	}





}
