package com.example.demo.repository;



import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Categoria;
import com.example.demo.modelo.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	
	@Query(value ="select * from producto  x where cod_cate = ?1", nativeQuery = true)
	public List<Producto> findByCategory(String categoriaid);
	

}
