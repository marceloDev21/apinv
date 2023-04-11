package com.sistema.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.inventario.model.Fornecedor;
import com.sistema.inventario.service.FornecedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@Operation(summary = "Endpoint responsável por buscar todos os Fornecedores",
//	        description = "Descrição do endpoint",
			responses = { @ApiResponse(responseCode = "200", description = "Consulta feita com sucesso"),
					@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
					@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao consultar os Fornecedores"),
					@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

			})
	@GetMapping
	public List<Fornecedor> obterTodos() {
		return fornecedorService.obterTodos();
	}

	@Operation(summary = "Endpoint responsável por buscar um unico Fornecedor", responses = {
			@ApiResponse(responseCode = "200", description = "Consulta feita com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao consultar o Fornecedor"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@GetMapping("/{id}")
	public Optional<Fornecedor> obterporId(@PathVariable Long id) {
		return fornecedorService.obterPorId(id);
	}

	@Operation(summary = "Endpoint responsável por adicionar um Fornecedor", responses = {
			@ApiResponse(responseCode = "200", description = "Cadastrou um Fornecedor"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao criar o Fornecedor"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@PostMapping
	public Fornecedor adicionar(@RequestBody Fornecedor fornecedor) {
		return fornecedorService.adicionar(fornecedor);

	}

	@Operation(summary = "Endpoint responsável por deletar um Fornecedor", responses = {
			@ApiResponse(responseCode = "200", description = "Fornecedor deletado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao deletar o Fornecedor"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		fornecedorService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável para atualizar um Local", responses = {
			@ApiResponse(responseCode = "200", description = "Fornecedor atualizado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao atualizar o Fornecedor"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {

		Optional<Fornecedor> fornecedorSalvo = fornecedorService.obterPorId(id);

		fornecedorSalvo.get().setNomeEmpresa(fornecedor.getNomeEmpresa());
		fornecedorSalvo.get().setCnpj(fornecedor.getCnpj());
		fornecedorSalvo.get().setTelefone(fornecedor.getTelefone());
		fornecedorSalvo.get().setEmail(fornecedor.getEmail());

		if (fornecedorSalvo.get().getId() == null) {
			return ResponseEntity.notFound().build();
		}

		Fornecedor fornecedorEditar = fornecedorService.PersistirFornecedor(fornecedorSalvo.get());
		return ResponseEntity.ok(fornecedorEditar);

	}

	@Operation(summary = "Endpoint responsável por filtrar um Fornecedor pelo CNPJ", responses = {
			@ApiResponse(responseCode = "200", description = "Fornecedor atualizado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao tentar encontrar o Fornecedor pelo CNPJ"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@GetMapping("/cnpj/{cnpj}")
	public Optional<Fornecedor> obterPorCnpj(@PathVariable String cnpj) {
		return fornecedorService.obterPorCnpj(cnpj);
	}


}
