package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.example.demo.modelo.Producto;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService serv;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?>findAll(){
		Object lista = serv.findAll();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<?>findbyId(@PathVariable int id){
		Object lista = serv.findById(id);
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/listarcategory/{categoriaId}")
	public ResponseEntity<?>findById(@PathVariable String categoriaId){
		Object lis = serv.listByCategory(categoriaId);
		return new ResponseEntity<>(lis,HttpStatus.OK);
	}
	
	

	@PostMapping("/grabar")
	public ResponseEntity<?>save(@RequestBody Producto prod){
		Producto newProduct = serv.insert(prod);
		return new ResponseEntity<>("Se creo nuevo Producto con ID : "+ newProduct.getCodPro(),HttpStatus.CREATED);

	}
	
	@PutMapping("/update/{productoId}")
	public ResponseEntity<?> update (@PathVariable Integer productoId,@RequestBody Producto prod){
		Producto p = serv.findById(productoId);
		if(p == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
		}
		serv.update(prod);
		return new ResponseEntity<>("Producto Actualizado Correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productoId}")
	public ResponseEntity<?> delete (@PathVariable Integer productoId){
		Producto p = serv.findById(productoId);
		if(p == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
		}
		serv.delete(productoId);
		Map<String,String> respuesta = new HashMap<String, String>(); //adhoc metodo
		respuesta.put("codigo","O0");
		respuesta.put("mensaje", "Se elimino correctamente el Producto con id : " + productoId);
		respuesta.put("fecOperacion",new Date().toString());
		return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
	}
}
