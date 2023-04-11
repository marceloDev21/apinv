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

import com.sistema.inventario.model.Posse;
import com.sistema.inventario.service.PosseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/posse")
public class PosseController {

	@Autowired
	private PosseService posseService;

	@Operation(summary = "Endpoint responsável por buscar todas as posses")
	@GetMapping
	public List<Posse> obterTodos() {
		return posseService.obterTodos();
	}

	@Operation(summary = "Endpoint responsável por buscar uma unica posse")
	@GetMapping("/{id}")
	public Optional<Posse> obterporId(@PathVariable Long id) {
		return posseService.obterPorId(id);
	}

	
	@Operation(
	        summary = "Endpoint responsável por adicionar uma posse",
	        responses = {
	                @ApiResponse(responseCode = "200", description = "Cadastrou uma posse"),
	                @ApiResponse(responseCode = "500", description = "Foi gerado um erro ao cadastrar uma posse")})
	@PostMapping
	public Posse adicionar(@RequestBody Posse posse) {
		return posseService.adicionar(posse);

	}

	@Operation(summary = "Endpoint responsável por deletar uma posse")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		posseService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável por atualizar uma posse")
	@PutMapping("/{id}")
	public Posse atualizar(@PathVariable Long id, @RequestBody Posse posse) {
		return posseService.atualizar(id, posse);

	}
}
