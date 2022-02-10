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


import com.example.demo.modelo.Rol;
import com.example.demo.service.RolService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rol")
public class RolRestController {

	@Autowired
	private RolService serv;
	
	@GetMapping("/listar")
	public ResponseEntity<?>findAll(){
		Object lista = serv.findAll();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<?>insert(@RequestBody Rol rol ){
		Rol newRol = serv.insertar(rol);
		return new ResponseEntity<>("Se agrego el nuevo Rol con Id : " +newRol.getCodRol() ,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{rolId}")
	@ApiOperation(value = "Actualiza los datos del Roles", httpMethod = "PUT", nickname = "agregarRoles")
	public ResponseEntity<?>update(@PathVariable String rolId, @RequestBody Rol newRol){
		
		Rol nRol = serv.findById(rolId);
		if(nRol == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
		}
		serv.update(newRol);
		return new ResponseEntity<>("Rol Actualizado Correctamente",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{rolId}")
	@ApiOperation(value = "Elimina el Registro de un Cliente", httpMethod = "DELETE", nickname = "agregarRoles")
	public ResponseEntity<?>delete(@PathVariable String rolId){
		Rol nRol = serv.findById(rolId);
		if(nRol == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado");
		}
		serv.delete(rolId);
		Map<String,String> respuesta = new HashMap<String, String>(); //adhoc metodo
		respuesta.put("codigo","O0");
		respuesta.put("mensaje", "Se elimino correctamente el Rol con id : " + rolId);
		respuesta.put("fecOperacion",new Date().toString());
		return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
	}

}
