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

import com.sistema.inventario.model.Marca;
import com.sistema.inventario.service.MarcaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@Operation(summary = "Endpoint responsável por buscar todos os Marcas")
	@GetMapping
	public List<Marca> obterTodos() {
		return marcaService.obterTodos();
	}
	@Operation(summary = "Endpoint responsável por buscar uma unica Marca")
	@GetMapping("/{id}")
	public Optional<Marca> obterporId(@PathVariable Long id) {
		return marcaService.obterPorId(id);
	}
	
	@Operation(
	        summary = "Endpoint responsável por adicionar uma Marca",
	        responses = {
	                @ApiResponse(responseCode = "200", description = "Criou uma Marca"),
	                @ApiResponse(responseCode = "500", description = "Foi gerado um erro ao criar a Marca")})
	@PostMapping
	public Marca adicionar(@RequestBody Marca marca) {
		return marcaService.adicionar(marca);

	}

	@Operation(summary = "Endpoint responsável por deletar uma Marca")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		marcaService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável por atualizar uma Marca")
	@PutMapping("/{id}")
	public Marca atualizar(@PathVariable Long id, @RequestBody Marca marca) {
		return marcaService.atualizar(id, marca);

	}

}