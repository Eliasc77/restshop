package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.DetallePedido;

@Repository
public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Integer>{

}
