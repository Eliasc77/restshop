package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, String> {

}
