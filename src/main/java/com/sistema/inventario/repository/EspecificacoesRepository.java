package com.sistema.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.inventario.model.Especificacoes;

@Repository
public interface EspecificacoesRepository extends JpaRepository<Especificacoes, Long> {

}