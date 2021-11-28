package com.cibertec.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.restaurante.entity.Mesa;
import com.cibertec.restaurante.repository.MesaRepository;

@Service
public class MesaServiceImpl implements MesaService {
	
	@Autowired
	private MesaRepository mesarepo;

	@Override
	public List<Mesa> listaMesa() {
		// TODO Auto-generated method stub
		return mesarepo.findAll();
	}

	@Override
	public Mesa insertaActualizaMesa(Mesa obj) {
		// TODO Auto-generated method stub
		return mesarepo.save(obj);
	}

	@Override
	public List<Mesa> listarPorDescmesaLike(String descmesa) {
		// TODO Auto-generated method stub
		return mesarepo.findByDescmesaLike(descmesa);
	}

}
