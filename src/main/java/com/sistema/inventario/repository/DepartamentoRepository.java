package com.sistema.inventario.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.model.Departamento;

	public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
