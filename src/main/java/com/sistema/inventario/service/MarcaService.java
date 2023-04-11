package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Marca;
import com.sistema.inventario.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	public List<Marca> obterTodos() {

		return marcaRepository.findAll();
	}

	public Optional<Marca> obterPorId(Long id) {

		return marcaRepository.findById(id);

	}

	public Marca adicionar(Marca marca) {

		marca.setId(null);
		return marcaRepository.save(marca);

	}

	public void deletar(Long id) {
		marcaRepository.deleteById(id);
	}

	public Marca atualizar(Long id, Marca marca) {

		marca.setId(id);
		return marcaRepository.save(marca);

	}

}
