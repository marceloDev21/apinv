package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Departamento;
import com.sistema.inventario.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> obterTodos() {
        
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> obterPorId(Long id) {

        return departamentoRepository.findById(id);

    }
    
    
//    public Optional<departamento> obterPorTipo(String tipo) {
//
//        return departamentoRepository.findByTipo(tipo);
//
//    }

    public Departamento adicionar(Departamento departamento) {

    	departamento.setId(null);
        return departamentoRepository.save(departamento);

    }

    public void deletar(Long id) {
    	departamentoRepository.deleteById(id);
    }

    public Departamento atualizar(Long id, Departamento departamento) {
   
    	departamento.setId(id);
        return departamentoRepository.save(departamento);

    }
    

}
