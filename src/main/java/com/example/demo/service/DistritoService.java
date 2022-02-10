package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Distrito;
import com.example.demo.repository.DistritoRepository;

@Service
@Transactional
public class DistritoService {

	@Autowired
	private DistritoRepository dist;

	private Collection<Distrito> itemsDistritos = new ArrayList<>();

	@PostConstruct
	public void initData() {

		Distrito distrito1 = new Distrito("L01", "Cercado de Lima", "A");
		Distrito distrito2 = new Distrito("L14", "La Molina", "A");
		Distrito distrito3 = new Distrito("L15", "La Victoria", "A");
		Distrito distrito4 = new Distrito("L16", "Lince", "A");
		Distrito distrito5 = new Distrito("L17", "Los Olivos", "A");
		Distrito distrito6 = new Distrito("L18", "Lurigancho", "A");
		Distrito distrito7 = new Distrito("L19", "Lurin", "A");
		Distrito distrito8 = new Distrito("L20", "Miraflores", "A");

		itemsDistritos.add(distrito1);
		itemsDistritos.add(distrito2);
		itemsDistritos.add(distrito3);
		itemsDistritos.add(distrito4);
		itemsDistritos.add(distrito5);
		itemsDistritos.add(distrito6);
		itemsDistritos.add(distrito8);
		itemsDistritos.add(distrito7);

		for (Distrito distrito : itemsDistritos) {
			insert(distrito);
		}
	}

	public Distrito insert(Distrito dis) {
		Distrito newDis = dist.save(dis);
		return newDis;
	}
	
	public Collection<Distrito> getAll(){
		return (Collection<Distrito>)dist.findAll();
	}
	
	public void Update(Distrito di) {
		dist.save(di);
	}
	
	public Distrito findById(String id) {
		return dist.findById(id).orElse(null);
	}
	
	public void delete(String id) {
		dist.deleteById(id);
	}

}
