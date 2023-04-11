package com.sistema.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.model.Propriedade;


public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {

}
