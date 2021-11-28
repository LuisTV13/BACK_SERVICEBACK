package com.cibertec.restaurante.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.restaurante.entity.Platillos;
import com.cibertec.restaurante.service.PlatilloService;
import com.cibertec.restaurante.utils.Constantes;



@RestController
@RequestMapping("/restaurante/platillos")
public class PlatillosController {
	
	@Autowired 
	private PlatilloService platilloservice; 
	
	@PostMapping("/registraPlatillo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPlatillo(@RequestBody Platillos obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Platillos objSalida = platilloservice.insertaActualizaPlatillos(obj);
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
	
	@PutMapping("/actualizarPlatillo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPlatillo(@RequestBody Platillos obj){
	
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCodigopro() != 0) {
				Platillos objSalida = platilloservice.insertaActualizaPlatillos(obj);
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
	
	@GetMapping("/listaPlatilloPorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Platillos>> listaPlatilloPorNombreLike(@PathVariable("nom") String nom){
		System.out.println("nom");
		List<Platillos> lista = null;
		try {
			if (nom.equals("todos")) {
				lista = platilloservice.listaPlatillos();
			}else {
				lista = platilloservice.listarPorDetalleproLike("%" + nom + "%");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	

}
