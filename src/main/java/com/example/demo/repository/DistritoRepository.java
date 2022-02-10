package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Distrito;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, String> {

}
