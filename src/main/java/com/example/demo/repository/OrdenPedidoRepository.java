package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.OrdenPedido;

@Repository
public interface OrdenPedidoRepository extends CrudRepository<OrdenPedido, Integer> {

}
