package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Posse;
import com.sistema.inventario.repository.PosseRepository;

@Service
public class PosseService {

	@Autowired
    private PosseRepository posseRepository;

    public List<Posse> obterTodos() {
        
        return posseRepository.findAll();
    }

    public Optional<Posse> obterPorId(Long id) {

        return posseRepository.findById(id);

    }
  

    public Posse adicionar(Posse posse) {

    	posse.setId(null);
        return posseRepository.save(posse);

    }

    public void deletar(Long id) {
    	posseRepository.deleteById(id);
    }

    public Posse atualizar(Long id, Posse posse) {
   
    	posse.setId(id);
        return posseRepository.save(posse);

    }
}
