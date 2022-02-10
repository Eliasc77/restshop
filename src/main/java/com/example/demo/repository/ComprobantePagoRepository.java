package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.ComprobantePago;

@Repository
public interface ComprobantePagoRepository extends CrudRepository<ComprobantePago, Integer> {

}
