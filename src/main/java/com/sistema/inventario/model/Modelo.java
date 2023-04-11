package com.sistema.inventario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modelo")
public class Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
//	@JsonIgnoreProperties("modelo")
//	@Valid
//	@OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Especificacoes> especificacoes;
	
//	@ManyToOne
//    @JoinColumn(name = "marca_id", referencedColumnName = "id")
//	private Marca marca;
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	

	

	

	



	
	
	
	
}
