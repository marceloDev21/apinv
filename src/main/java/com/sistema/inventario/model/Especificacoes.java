package com.sistema.inventario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "especificacoes")
public class Especificacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String serie;
	
	private String descricoes;
	
//	@JsonIgnoreProperties("especificacoes")
	@ManyToOne(optional = true)
	@JoinColumn(name = "modelo_id", referencedColumnName = "id")
	private Modelo modelo;
	
	@ManyToOne
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
	private Marca marca;
	
	// GET / SET //

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDescricoes() {
		return descricoes;
	}

	public void setDescricoes(String descricoes) {
		this.descricoes = descricoes;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
}
