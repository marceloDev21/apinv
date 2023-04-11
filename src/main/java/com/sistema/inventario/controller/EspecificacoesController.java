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

import com.sistema.inventario.model.Especificacoes;
import com.sistema.inventario.service.EspecificacoesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/especificacoes")
public class EspecificacoesController {

	@Autowired
	private EspecificacoesService especificacoesService;

	@Operation(summary = "Endpoint responsável por buscar todas as Especificacoes")
	@GetMapping
	public List<Especificacoes> obterTodos() {
		return especificacoesService.obterTodos();
	}

	@Operation(summary = "Endpoint responsável por buscar uma unica Especificação")
	@GetMapping("/{id}")
	public Optional<Especificacoes> obterporId(@PathVariable Long id) {
		return especificacoesService.obterPorId(id);
	}

	
	@Operation(
	        summary = "Endpoint responsável por adicionar uma Especificacoes",
	        responses = {
	                @ApiResponse(responseCode = "200", description = "Cadastrou uma Especificação"),
	                @ApiResponse(responseCode = "500", description = "Foi gerado um erro ao cadastrar uma Especificação")})
	@PostMapping
	public Especificacoes adicionar(@RequestBody Especificacoes especificacoes) {
		return especificacoesService.adicionar(especificacoes);

	}

	@Operation(summary = "Endpoint responsável por deletar uma Especificações")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		especificacoesService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável por atualizar uma Especificação")
	@PutMapping("/{id}")
	public Especificacoes atualizar(@PathVariable Long id, @RequestBody Especificacoes especificacoes) {
		return especificacoesService.atualizar(id, especificacoes);

	}
}
