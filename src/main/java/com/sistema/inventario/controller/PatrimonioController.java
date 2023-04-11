package com.sistema.inventario.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import com.sistema.inventario.model.Departamento;
import com.sistema.inventario.model.Patrimonio;
import com.sistema.inventario.service.PatrimonioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/patrimonio")
public class PatrimonioController {
	
	@Autowired
	private PatrimonioService entityService;

	@Autowired
	private PatrimonioService patrimonioService;

	@Operation(summary = "Endpoint responsável por buscar todos os patrimonios",
//	        description = "Descrição do endpoint",
			responses = { @ApiResponse(responseCode = "200", description = "Consulta feita com sucesso"),
					@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
					@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao consultar os patrimonios"),
					@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

			})
	@GetMapping
	public List<Patrimonio> obterTodos() {
		return patrimonioService.obterTodos();
	}

	@Operation(summary = "Endpoint responsável por buscar um unico patrimonio", responses = {
			@ApiResponse(responseCode = "200", description = "Consulta feita com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao consultar o patrimonio"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@GetMapping("/{id}")
	public Optional<Patrimonio> obterporId(@PathVariable Long id) {
		return patrimonioService.obterPorId(id);
	}

	@Operation(summary = "Endpoint responsável por adicionar um patrimonio", responses = {
			@ApiResponse(responseCode = "200", description = "Cadastrou um patrimonio"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao criar o patrimonio"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	
	@PostMapping
	public ResponseEntity<Patrimonio> incluir(@Valid @RequestBody Patrimonio entity) {

		entity.getPosse().forEach((p) -> {
			p.setPatrimonio(entity);
		});

		Patrimonio entitySalva = entityService.adicionar(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entitySalva);
	}

	@Operation(summary = "Endpoint responsável por deletar um patrimonio", responses = {
			@ApiResponse(responseCode = "200", description = "patrimonio deletado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao deletar o patrimonio"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		patrimonioService.deletar(id);
	}

	@Operation(summary = "Endpoint responsável para atualizar um Local", responses = {
			@ApiResponse(responseCode = "200", description = "patrimonio atualizado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao atualizar o patrimonio"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@PutMapping("/{id}")
	public ResponseEntity<Patrimonio> atualizar(@PathVariable Long id, @RequestBody Patrimonio patrimonio) {

		Optional<Patrimonio> patrimonioSalvo = patrimonioService.obterPorId(id);
		
		patrimonioSalvo.get().getPosse().clear();
		patrimonioSalvo.get().getPosse().addAll(patrimonio.getPosse());
		patrimonioSalvo.get().getPosse().forEach((p) -> {
			p.setPatrimonio(patrimonioSalvo.get());
		});
			
		patrimonioSalvo.get().setCodigo(patrimonio.getCodigo());
		patrimonioSalvo.get().setObservacao(patrimonio.getObservacao());
		patrimonioSalvo.get().setNome(patrimonio.getNome());
		patrimonioSalvo.get().setSituacao(patrimonio.getSituacao());
		patrimonioSalvo.get().setDepartamento(patrimonio.getDepartamento());
		patrimonioSalvo.get().setTipo(patrimonio.getTipo());
		patrimonioSalvo.get().setPropriedade(patrimonio.getPropriedade());
		patrimonioSalvo.get().setDtCadastro(patrimonio.getDtCadastro());
		patrimonioSalvo.get().setDt_entrega(patrimonio.getDt_entrega());
		patrimonioSalvo.get().setEspecificacoes(patrimonio.getEspecificacoes());
		patrimonioSalvo.get().setResponsavel(patrimonio.getResponsavel());
		patrimonioSalvo.get().setValor(patrimonio.getValor());

		
		
		if (patrimonioSalvo.get().getId() == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(patrimonio, patrimonioSalvo.get(), "id", "posse");
		Patrimonio patrimonioEditar = patrimonioService.Persistirpatrimonio(patrimonioSalvo.get());
		return ResponseEntity.ok(patrimonioEditar);

	}

	@Operation(summary = "Endpoint responsável por filtrar um patrimonio pelo codigo", responses = {
			@ApiResponse(responseCode = "200", description = "patrimonio encontrado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao tentar encontrar o patrimonio pelo codigo"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@GetMapping("/codigo/{codigo}")
	public Optional<Patrimonio> obterPorCodigo(@PathVariable String codigo) {
		return patrimonioService.obterPorCodigo(codigo);
	}

	@Operation(summary = "Endpoint responsável por Listar todos os itens de um determinado departamento", description = "Passe o ID do departamento como parâmetro", responses = {
			@ApiResponse(responseCode = "200", description = "Itens encontrado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Foi gerado um erro ao tentar encontrar o item"),
			@ApiResponse(responseCode = "404", description = "URL pesquisada não corresponde "),
			@ApiResponse(responseCode = "403", description = "Você não tem permissão"),

	})
	@GetMapping("/departamento/{departamento}")
	public List<Patrimonio> obterPorDepartamento(@PathVariable Departamento departamento) {
		return patrimonioService.obterPorDepartamento(departamento);
	}

}
