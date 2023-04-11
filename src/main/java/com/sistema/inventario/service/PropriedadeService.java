package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Propriedade;
import com.sistema.inventario.repository.PropriedadeRepository;

@Service
public class PropriedadeService {

	@Autowired
    private PropriedadeRepository propriedadeRepository;

    public List<Propriedade> obterTodos() {
        
        return propriedadeRepository.findAll();
    }

    public Optional<Propriedade> obterPorId(Long id) {

        return propriedadeRepository.findById(id);

    }
  

    public Propriedade adicionar(Propriedade propriedade) {

    	propriedade.setId(null);
        return propriedadeRepository.save(propriedade);

    }

    public void deletar(Long id) {
    	propriedadeRepository.deleteById(id);
    }

    public Propriedade atualizar(Long id, Propriedade propriedade) {
   
    	propriedade.setId(id);
        return propriedadeRepository.save(propriedade);

    }
}
