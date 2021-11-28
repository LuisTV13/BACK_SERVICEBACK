package com.cibertec.restaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.restaurante.entity.Reserva;
import com.cibertec.restaurante.repository.ReservaRepository;


@Service
public class ReservaServiceImpl  implements  ReservaService{

	
	@Autowired
	private ReservaRepository reservarepo;

	@Override
	public List<Reserva> listaReserva() {
		// TODO Auto-generated method stub
		return reservarepo.findAll();
	}

	@Override
	public Reserva insertaActualizaReserva(Reserva obj) {
		// TODO Auto-generated method stub
		return reservarepo.save(obj);
	}

	@Override
	public List<Reserva> listarPorComentarioLike(String comentario) {
		// TODO Auto-generated method stub
		return reservarepo.findByComentarioLike(comentario);
	}

	@Override
	public void eliminarReserva(Long codreserva) {
		// TODO Auto-generated method stub
		reservarepo.deleteById(codreserva);
	}

	@Override
	public Optional<Reserva> buscaPorId(Long codreserva) {
		// TODO Auto-generated method stub
		return reservarepo.findById(codreserva);
	}



}
