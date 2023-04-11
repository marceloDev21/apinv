package com.sistema.inventario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.model.Departamento;
import com.sistema.inventario.model.Patrimonio;

public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {

	Optional<Patrimonio> findByCodigo(String codigo);

	List<Patrimonio> findByDepartamento(Departamento departamento);
	 
}
