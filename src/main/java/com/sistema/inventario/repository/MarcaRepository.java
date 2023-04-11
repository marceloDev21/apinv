package com.sistema.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.inventario.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}