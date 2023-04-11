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

import com.sistema.inventario.model.Pessoa;
import com.sistema.inventario.service.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Operation(summary = "Endpoint responsável por buscar todas as pessoas")
	@GetMapping
	public List<Pessoa> obterTodos() {
		return pessoaService.obterTodos();
	}

	@Operation(summary = "Endpoint responsável por buscar uma unica pessoa")
	@GetMapping("/{id}")
	public Optional<Pessoa> obterporId(@PathVariable Long id) {
		return pessoaService.obterPorId(id);
	}

	
	@Operation(
	        summary = "Endpoint responsável por adicionar uma pessoa",
	        responses = {
	                @ApiResponse(responseCode = "200", description = "Cadastrou uma pessoa"),
	                @ApiResponse(responseCode = "500", description = "Foi gerado um erro ao cadastrar uma pessoa")})
	@PostMapping
	public Pessoa adicionar(@RequestBody Pessoa pessoa) {
		return pessoaService.adicionar(pessoa);

	}

	@Operation(summary = "Endpoint responsável por deletar uma pessoa")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		pessoaService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável por atualizar uma pessoa")
	@PutMapping("/{id}")
	public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return pessoaService.atualizar(id, pessoa);

	}
}
