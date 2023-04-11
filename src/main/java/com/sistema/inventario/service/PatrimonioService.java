package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Departamento;
import com.sistema.inventario.model.Patrimonio;
import com.sistema.inventario.repository.PatrimonioRepository;

@Service
public class PatrimonioService {

	@Autowired
    private PatrimonioRepository patrimonioRepository;

    public List<Patrimonio> obterTodos() {
        
        return patrimonioRepository.findAll();
    }

    public Optional<Patrimonio> obterPorId(Long id) {

        return patrimonioRepository.findById(id);

    }
    
    
    public Patrimonio adicionar(Patrimonio patrimonio) {

    	patrimonio.setId(null);
        return patrimonioRepository.save(patrimonio);

    }

    public void deletar(Long id) {
    	patrimonioRepository.deleteById(id);
    }

    public Patrimonio Persistirpatrimonio(Patrimonio patrimonio) {
		return patrimonioRepository.saveAndFlush(patrimonio);
	}
    
    public Optional<Patrimonio> obterPorCodigo(String codigo) {

        return patrimonioRepository.findByCodigo(codigo);

    }
    
    public List<Patrimonio> obterPorDepartamento(Departamento departamento) {

        return patrimonioRepository.findByDepartamento(departamento);

    }

    
}
