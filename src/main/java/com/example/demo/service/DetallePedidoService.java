package com.example.demo.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.DetallePedido;
import com.example.demo.repository.DetallePedidoRepository;

@Service
@Transactional
public class DetallePedidoService {

	@Autowired
	private DetallePedidoRepository repo;
	
	public Collection<DetallePedido> findAll(){
		return (Collection<DetallePedido>) repo.findAll();
	}
	
	public DetallePedido insert(DetallePedido dpedido) {
		DetallePedido ndpedido = repo.save(dpedido);
		return ndpedido;
	}
}
