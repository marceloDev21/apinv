package com.sistema.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.model.Fornecedor;
import com.sistema.inventario.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> obterTodos() {
        
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> obterPorId(Long id) {

        return fornecedorRepository.findById(id);

    }
    
    
    public Fornecedor adicionar(Fornecedor fornecedor) {

    	fornecedor.setId(null);
        return fornecedorRepository.save(fornecedor);

    }

    public void deletar(Long id) {
    	fornecedorRepository.deleteById(id);
    }

    public Fornecedor PersistirFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.saveAndFlush(fornecedor);
	}
    
    public Optional<Fornecedor> obterPorCnpj(String cnpj) {

        return fornecedorRepository.findByCnpj(cnpj);

    }
    

    
}
