package com.sistema.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.inventario.model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

	List<Modelo> findByNome(String nome);
	
}