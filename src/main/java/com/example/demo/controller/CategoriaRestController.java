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

import com.example.demo.modelo.Categoria;
 
import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaService serv;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?>listAll(){
		Object listar = serv.findAll();
		return new ResponseEntity<>(listar,HttpStatus.OK);
	}
	
	@PostMapping("/grabar")
	public ResponseEntity<?>insert(@RequestBody Categoria newCate){
		Categoria ncate = serv.saveCategoria(newCate);
		return new ResponseEntity<>("Se agrego correctamente la categoria con Id: "+ ncate.getCodCate(), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{categoriaId}")
	public ResponseEntity<?>update(@PathVariable String categoriaId, @RequestBody Categoria catego){
		Categoria c = serv.findById(categoriaId);
		if(c == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrado");
		}
		serv.update(catego);
		return new ResponseEntity<>("Se actualizzo correctamente la Categoria con Id: " +c.getCodCate().toString(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{categoriaId}")
	public ResponseEntity<?>delete(@PathVariable String categoriaId){
		Categoria c = serv.findById(categoriaId);
		if(c == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrado");
		}
		serv.delete(categoriaId);
		Map<String,String> respuesta = new HashMap<String, String>(); //adhoc metodo
		respuesta.put("codigo","O0");
		respuesta.put("mensaje", "Se elimino correctamente la Categoria con id : " + categoriaId);
		respuesta.put("fecOperacion",new Date().toString());
		return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
	}
	

}
