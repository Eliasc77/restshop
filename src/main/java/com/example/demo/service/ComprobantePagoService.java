package com.example.demo.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.ComprobantePago;
import com.example.demo.repository.ComprobantePagoRepository;

@Service
@Transactional
public class ComprobantePagoService {

	@Autowired
	private ComprobantePagoRepository repo;
	
	public Collection<ComprobantePago> findAll(){
		return (Collection<ComprobantePago>) repo.findAll();
	}
	
	public ComprobantePago insert(ComprobantePago comprop) {
		ComprobantePago ncomprobantep = repo.save(comprop);
		return ncomprobantep;
	}
}
