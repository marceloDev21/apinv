package com.sistema.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.inventario.model.Propriedade;
import com.sistema.inventario.service.PropriedadeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/propriedade")
public class PropriedadeController {
	

	@Autowired
	private PropriedadeService propriedadeService;

	@Operation(summary = "Endpoint responsável por buscar todas as Propriedades")
	@GetMapping
	public List<Propriedade> obterTodos() {
		return propriedadeService.obterTodos();
	}

	@Operation(summary = "Endpoint responsável por buscar uma unica Propriedade")
	@GetMapping("/{id}")
	public Optional<Propriedade> obterporId(@PathVariable Long id) {
		return propriedadeService.obterPorId(id);
	}

	
	@Operation(
	        summary = "Endpoint responsável por adicionar uma Propriedade",
	        responses = {
	                @ApiResponse(responseCode = "200", description = "Cadastrou uma Propriedade"),
	                @ApiResponse(responseCode = "500", description = "Foi gerado um erro ao cadastrar uma Propriedade")})
	@PostMapping
	public Propriedade adicionar(@RequestBody Propriedade propriedade) {
		return propriedadeService.adicionar(propriedade);

	}

	@Operation(summary = "Endpoint responsável por deletar uma Propriedade")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		propriedadeService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável por atualizar uma Propriedade")
	@PutMapping("/{id}")
	public Propriedade atualizar(@PathVariable Long id, @RequestBody Propriedade propriedade) {
		return propriedadeService.atualizar(id, propriedade);

	}
	
}
