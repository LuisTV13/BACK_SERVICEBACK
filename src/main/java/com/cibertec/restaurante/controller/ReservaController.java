package com.cibertec.restaurante.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.restaurante.entity.Reserva;
import com.cibertec.restaurante.service.ReservaService;
import com.cibertec.restaurante.utils.Constantes;



@RestController
@RequestMapping("/restaurante/reserva")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {
	
	@Autowired 
	private ReservaService reservaservice; 
	
	@PostMapping("/registraReserva")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaReserva(@RequestBody Reserva obj){
		
		
		Map<String, Object> salida = new HashMap<>();
		System.out.println(obj.getFechareserva());
		try {
			Reserva objSalida = reservaservice.insertaActualizaReserva(obj);
		
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		}catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		} 
		
		return ResponseEntity.ok(salida);
		
		
	}
	
	@PutMapping("/actualizarReserva")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaReserva(@RequestBody Reserva obj){
	
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCodreserva() != 0) {
				Reserva objSalida = reservaservice.insertaActualizaReserva(obj);
				if (objSalida == null) {
					salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
				} else {
					salida.put("mensaje", "Se actualizo correctamente");
				}	
			}else {
				salida.put("mensaje", "El ID del platillo debe ser diferente cero");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
		
		
	}
	
	@GetMapping("/listaReservaPorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Reserva>> listaReservaPorNombreLike(@PathVariable("nom") String nom){
		System.out.println("nom");
		List<Reserva> lista = null;
		try {
			if (nom.equals("todos")) {
				lista = reservaservice.listaReserva();
			}else {
				lista = reservaservice.listarPorComentarioLike("%" + nom + "%");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	@DeleteMapping("/eliminarReservaporId/{id}")
	@ResponseBody
	public ResponseEntity<Boolean> eliminarReserva(@PathVariable("id") Long codreserva){
		reservaservice.eliminarReserva(codreserva);
		return ResponseEntity.ok(!(reservaservice.buscaPorId(codreserva)!=null));
	}
	
	

}
