package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Categoria;
import com.example.demo.modelo.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService {
	
	@Autowired
	private ProductoRepository repo;
	
	
	public Producto insert(Producto p) {
		Producto newProduct = repo.save(p);
		return newProduct;
	}
	

	
	public Collection<Producto> findAll(){
		return (Collection<Producto>)repo.findAll();
	}
	
	public Collection<Producto> listByCategory(String catego){		
		return (Collection<Producto>)repo.findByCategory(catego);
	}
	
	
	public void update(Producto p ) {
		repo.save(p);
		
	}
	
	public Producto findById(int i) {
		return repo.findById(i).orElse(null);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}

}
