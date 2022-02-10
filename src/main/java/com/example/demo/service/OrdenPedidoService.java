package com.example.demo.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.OrdenPedido;
import com.example.demo.repository.OrdenPedidoRepository;

@Service
@Transactional
public class OrdenPedidoService {
	
	@Autowired
	private OrdenPedidoRepository repo;
	
	public Collection<OrdenPedido> findAll(){
		return (Collection<OrdenPedido>)repo.findAll();
	}
	
	public OrdenPedido insertar(OrdenPedido ord) {
		OrdenPedido orde= repo.save(ord);
		return orde;
	}
	
	public void update(OrdenPedido or) {
		repo.save(or);
	}
	
	public OrdenPedido findById(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteById(int Id) {
		repo.deleteById(Id);
	}

}
