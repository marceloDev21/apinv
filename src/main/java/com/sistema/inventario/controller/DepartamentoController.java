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

import com.sistema.inventario.model.Departamento;
//import com.sistema.inventario.repository.departamentoRepository;
import com.sistema.inventario.service.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;


	@Operation(summary = "Endpoint responsável por buscar todos os departamentos")
	@GetMapping
	public List<Departamento> obterTodos() {
		return departamentoService.obterTodos();
	}
	@Operation(summary = "Endpoint responsável por buscar um unico departamento")
	@GetMapping("/{id}")
	public Optional<Departamento> obterporId(@PathVariable Long id) {
		return departamentoService.obterPorId(id);
	}

	@Operation(
	        summary = "Endpoint responsável por adicionar um departamento",
	        responses = {
	                @ApiResponse(responseCode = "200", description = "Adicionou um departamento"),
	                @ApiResponse(responseCode = "500", description = "Foi gerado um erro ao criar o departamento")})
	@PostMapping
	public Departamento adicionar(@RequestBody Departamento departamento) {
		return departamentoService.adicionar(departamento);

	}
	@Operation(summary = "Endpoint responsável por deletar um departamento")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		departamentoService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável por atualizar um departamento")
	@PutMapping("/{id}")
	public Departamento atualizar(@PathVariable Long id, @RequestBody Departamento departamento) {
		return departamentoService.atualizar(id, departamento);

	}
	
}
