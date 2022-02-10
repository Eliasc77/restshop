package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.modelo.Rol;
import com.example.demo.repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	private RolRepository repo;
	
	private Collection<Rol> listRol = new ArrayList<>();

	
	public Collection<Rol> findAll(){
		return (Collection<Rol>)repo.findAll();
	}
	
	public Rol insertar(Rol rol) {
		Rol newRol = repo.save(rol);
		return newRol;
	}
	
	public Rol findById(String id) {
		return repo.findById(id).orElse(null);
	}
	
	public void update(Rol r) {
		repo.save(r);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
}
