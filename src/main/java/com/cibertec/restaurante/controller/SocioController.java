package com.cibertec.restaurante.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cibertec.restaurante.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.cibertec.restaurante.entity.Socio;
import com.cibertec.restaurante.service.SocioService;

@RestController
@RequestMapping("/restaurante/socio")
@CrossOrigin(origins = "http://localhost:4200")
public class SocioController {
   
	@Autowired
	private SocioService socioservice;
	
	
	@PostMapping("/registraSocio")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaSocio(@RequestBody Socio obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			if(obj.getEstadoso() == 0) {
				obj.setEstadoso(1);
			}
			Socio objSalida = socioservice.insertaActualizaSocio(obj);
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
	
	@PutMapping("/actualizarSocio")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaSocio(@RequestBody Socio obj){
	
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCodigoso() != 0) {
				Socio objSalida = socioservice.insertaActualizaSocio(obj);
				if (objSalida == null) {
					salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
				} else {
					salida.put("mensaje", "Se actualizo correctamente");
				}	
			}else {
				salida.put("mensaje", "El ID del Socio debe ser diferente cero");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
		
		
	}
	
	@GetMapping("/listaSocioPorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Socio>> listaPerfilPorNombreLike(@PathVariable("nom") String nom){
		System.out.println("nom");
		List<Socio> lista = null;
		try {
			if (nom.equals("todos")) {
				lista = socioservice.listaSocio();
			}else {
				lista = socioservice.listarPorNombresoLike("%" + nom + "%");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	
	@GetMapping("/listaSocioPorEstadoLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Socio>> listaSocioPorEstadoLike(@PathVariable("nom") int nom){
		System.out.println("nom");
		List<Socio> lista = null;
		try {
				lista = socioservice.listarPorEstadoLike(nom);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	
	
}
