package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Modelo;
import com.sistema.inventario.repository.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository modeloRepository;

	public List<Modelo> obterTodos() {

		return modeloRepository.findAll();
	}

	public Optional<Modelo> obterPorId(Long id) {

		return modeloRepository.findById(id);

	}

	public Modelo adicionar(Modelo modelo) {

		modelo.setId(null);
		return modeloRepository.save(modelo);

	}

	public void deletar(Long id) {
		modeloRepository.deleteById(id);
	}

	public Modelo atualizar(Long id, Modelo modelo) {

		modelo.setId(id);
		return modeloRepository.save(modelo);

	}

	public List<Modelo> obterNomesModelo(String nome) {

        return modeloRepository.findByNome(nome);

    }
	
}
