package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.ComprobantePago;

import com.example.demo.service.ComprobantePagoService;

@RestController
@RequestMapping("/comprobantePago")
public class ComprobantePagoRestController {

	@Autowired
	private ComprobantePagoService serv;
	
	@GetMapping("/listar")
	public ResponseEntity<?>findAll(){
		Object lista = serv.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@PostMapping("/grabar")
	public ResponseEntity<?>insert(@RequestBody ComprobantePago dcompra){
		ComprobantePago ncompcompra = serv.insert(dcompra);
		return new ResponseEntity<>("se agrego correctamente el item : " + ncompcompra.getCompPago(), HttpStatus.CREATED);
	}
}
