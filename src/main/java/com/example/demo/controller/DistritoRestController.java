package com.example.demo.controller;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.modelo.Distrito;
import com.example.demo.service.DistritoService;

@RestController
@RequestMapping("/distrito")
public class DistritoRestController {
	
	@Autowired
	private DistritoService distService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> findAll(){
		Object cli = distService.getAll();
		return new ResponseEntity<>(cli,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Distrito dist){
		Distrito newDist = distService.insert(dist);
		return new ResponseEntity<>("Se agrego Distrito N°: "+ newDist.getCodPostal().toString(),HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{distritoId}")
	public ResponseEntity<?> update(@PathVariable String distritoId, @RequestBody Distrito newdist){
		Distrito dis = distService.findById(distritoId);
		if(dis== null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Distrito no encontrado");
		}else {
			distService.Update(newdist);
		}
		
		return new ResponseEntity<>("Cliente Actualizado Correctamente",HttpStatus.OK);
	}

	@DeleteMapping("/delete/{distritoId}")
	public ResponseEntity<?>delete(@PathVariable String distritoId){
		Distrito dis = distService.findById(distritoId);
		if(dis == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Distrito no encontrado");
		}
		distService.delete(distritoId);
		Map<String,String> respuesta = new HashMap<String, String>(); //adhoc metodo
		respuesta.put("codigo","O0");
		respuesta.put("mensaje", "Se elimino correctamente el Distrito con id : " + distritoId);
		respuesta.put("fecOperacion",new Date().toString());
		return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
	}
}
