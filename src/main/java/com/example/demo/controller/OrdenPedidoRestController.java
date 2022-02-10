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


import com.example.demo.modelo.OrdenPedido;
import com.example.demo.service.OrdenPedidoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ordenPedido")
public class OrdenPedidoRestController {
	
	@Autowired
	private OrdenPedidoService serv;
	
	@GetMapping("/listar")
	public ResponseEntity<?>findAll(){
		Object lista = serv.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@PostMapping("/grabar")
	public ResponseEntity<?>insert(@RequestBody OrdenPedido opedido){
		OrdenPedido newOrdenp = serv.insertar(opedido);
		return new ResponseEntity<>("Se agrego el Pedido con Id : " +newOrdenp.getNumPedido(), HttpStatus.CREATED);
	}
	

	
	@PutMapping("/update/{ordenpedId}")
	@ApiOperation(value = "Actualiza los datos del Cliente", httpMethod = "PUT", nickname = "agregarClientes")
	public ResponseEntity<?>update(@PathVariable Integer ordenpedId, @RequestBody OrdenPedido newOrden){
		
		OrdenPedido orden = serv.findById(ordenpedId);
		if(orden == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden Pedido no encontrado");
		}
		serv.update(newOrden);
		return new ResponseEntity<>("Pedido Actualizado Correctamente",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{ordenpedId}")
	@ApiOperation(value = "Elimina el Registro de un Cliente", httpMethod = "DELETE", nickname = "agregarClientes")
	public ResponseEntity<?>delete(@PathVariable Integer ordenpedId){
		OrdenPedido orden = serv.findById(ordenpedId);
		if(orden == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden Pedido no encontrado");
		}
		serv.deleteById(ordenpedId);
		Map<String,String> respuesta = new HashMap<String, String>(); //adhoc metodo
		respuesta.put("codigo","O0");
		respuesta.put("mensaje", "Se elimino correctamente el Pedido con id : " + ordenpedId);
		respuesta.put("fecOperacion",new Date().toString());
		return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
	}

	
	
}
