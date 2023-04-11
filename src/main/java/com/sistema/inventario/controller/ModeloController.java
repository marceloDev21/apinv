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

import com.sistema.inventario.model.Modelo;
import com.sistema.inventario.service.ModeloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

	@Autowired
	private ModeloService modeloService;

	@Operation(summary = "Endpoint responsável por buscar todos os Modelos")
	@GetMapping
	public List<Modelo> obterTodos() {
		return modeloService.obterTodos();
	}
	@Operation(summary = "Endpoint responsável por buscar um unico Modelo")
	@GetMapping("/{id}")
	public Optional<Modelo> obterporId(@PathVariable Long id) {
		return modeloService.obterPorId(id);
	}
	
	@Operation(
	        summary = "Endpoint responsável por adicionar um Modelo",
	        responses = {
	                @ApiResponse(responseCode = "200", description = "Criou um Modelo"),
	                @ApiResponse(responseCode = "500", description = "Foi gerado um erro ao criar o Modelo")})
	@PostMapping
	public Modelo adicionar(@RequestBody Modelo modelo) {
		return modeloService.adicionar(modelo);

	}

	@Operation(summary = "Endpoint responsável por deletar um Modelo")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		modeloService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável por atualizar um Modelo")
	@PutMapping("/{id}")
	public Modelo atualizar(@PathVariable Long id, @RequestBody Modelo modelo) {
		return modeloService.atualizar(id, modelo);

	}
	
	@Operation(summary = "Endpoint responsável por Buscar os modelos com o mesmo nome",
			description = " Busca os modelos com o mesmo nome com especificações diferentes", responses = {
			@ApiResponse(responseCode = "200", description = "Nome do modelo encontrado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao tentar encontrar o modelo pelo nome"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@GetMapping("/nome/{nome}")
	public List<Modelo> obterNomesModelo(@PathVariable String nome) {
		return modeloService.obterNomesModelo(nome);
	}

}