package com.cibertec.restaurante.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.cibertec.restaurante.utils.*;
import com.cibertec.restaurante.entity.Mesa;
import com.cibertec.restaurante.service.MesaService;

@RestController
@RequestMapping("/restaurante/mesa")
@CrossOrigin(origins ="http://localhost:4200")
public class MesaController {
	
	@Autowired
	private MesaService mesaservice;
	

	@PostMapping("/registraMesa")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMesa(@RequestBody Mesa obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			if(obj.getCodmesa() == 0) {
				obj.setIdtipoest(1);
			}
			Mesa objSalida = mesaservice.insertaActualizaMesa(obj);
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
	
	@PutMapping("/actualizarMesa")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaMesa(@RequestBody Mesa obj){
	
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCodmesa() != 0) {
				Mesa objSalida = mesaservice.insertaActualizaMesa(obj);
				if (objSalida == null) {
					salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
				} else {
					salida.put("mensaje", "Se actualizo correctamente");
				}	
			}else {
				salida.put("mensaje", "El ID de la mesa debe ser diferente cero");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
		
		
	}
	
	@GetMapping("/listaMesaPorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Mesa>> listaMesaPorNombreLike(@PathVariable("nom") String nom){
		System.out.println("nom");
		List<Mesa> lista = null;
		try {
			if (nom.equals("todos")) {
				lista = mesaservice.listaMesa();
			}else {
				lista = mesaservice.listarPorDescmesaLike("%" + nom + "%");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	

}
