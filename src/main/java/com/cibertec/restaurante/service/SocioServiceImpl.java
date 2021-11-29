package com.cibertec.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.restaurante.entity.Socio;
import com.cibertec.restaurante.repository.SocioRepository;


@Service
public class SocioServiceImpl  implements  SocioService{

	
	@Autowired
	private SocioRepository sociorepo;

	@Override
	public List<Socio> listaSocio() {
		// TODO Auto-generated method stub
		return sociorepo.findAll();
	}

	@Override
	public Socio insertaActualizaSocio(Socio obj) {
		// TODO Auto-generated method stub
		return sociorepo.save(obj);
	}

	@Override
	public List<Socio> listarPorNombresoLike(String nombreso) {
		// TODO Auto-generated method stub
		return sociorepo.findByNombresoLike(nombreso);
	}

	@Override
	public List<Socio> listarPorEstadoLike(int estadoso) {
		// TODO Auto-generated method stub
		return sociorepo.findByEstadosoLike(estadoso);
	}
	

}
