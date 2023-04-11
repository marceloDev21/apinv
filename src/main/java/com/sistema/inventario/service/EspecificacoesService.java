package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Especificacoes;
import com.sistema.inventario.repository.EspecificacoesRepository;

@Service
public class EspecificacoesService {

	@Autowired
    private EspecificacoesRepository especificacoesRepository;

    public List<Especificacoes> obterTodos() {
        
        return especificacoesRepository.findAll();
    }

    public Optional<Especificacoes> obterPorId(Long id) {

        return especificacoesRepository.findById(id);

    }

    public Especificacoes adicionar(Especificacoes especificacoes) {

    	especificacoes.setId(null);
        return especificacoesRepository.save(especificacoes);

    }

    public void deletar(Long id) {
    	especificacoesRepository.deleteById(id);
    }

    public Especificacoes atualizar(Long id, Especificacoes especificacoes) {
   
    	especificacoes.setId(id);
        return especificacoesRepository.save(especificacoes);

    }
}
