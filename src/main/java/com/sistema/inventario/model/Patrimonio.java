package com.sistema.inventario.model;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sistema.inventario.enuns.Situacao;

@Entity
@Table(name = "patrimonio")
public class Patrimonio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;

	private String observacao;
	
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@UpdateTimestamp
	@Column(name="dt_cadastro")
	private LocalDateTime dtCadastro;
	
	@Column(nullable = false)
	private String nome;
	
	private Date dt_entrega;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao")
	private Situacao situacao;
	
	
	private Double valor;
	
	@OneToOne
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
	private Tipo tipo;
	
	@ManyToOne
    @JoinColumn(name = "responsavel_id", referencedColumnName = "id")
	private Pessoa responsavel;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	@ManyToOne
    @JoinColumn(name = "propriedade_id", referencedColumnName = "id")
	private Propriedade propriedade;
	
	@ManyToOne
	@JoinColumn(name="especificacoes_id", referencedColumnName= "id")
	private Especificacoes especificacoes;
	
	@JsonIgnoreProperties("patrimonio")
	@Valid
	@OneToMany(mappedBy = "patrimonio", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Posse> posse = new HashSet<Posse>();
	
	@Override
	public int hashCode() {
		return Objects.hash(id, posse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patrimonio other = (Patrimonio) obj;
		return Objects.equals(id, other.id) && Objects.equals(posse, other.posse);
	}

	//	GET/SET //

	
	public Especificacoes getEspecificacoes() {
		return especificacoes;
	}
	
	public void setEspecificacoes(Especificacoes especificacoes) {
		this.especificacoes = especificacoes;
	}

	public void setPosse(Set<Posse> posse) {
		this.posse = posse;
	}


	public Set<Posse> getPosse() {
		return posse;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDt_entrega() {
		return dt_entrega;
	}

	public void setDt_entrega(Date dt_entrega) {
		this.dt_entrega = dt_entrega;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Pessoa getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Propriedade getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	 // setar a data de cadastro da tarefa para cadastrar data automático assim que
    // for salvo
    @PrePersist
    public void beforeSave() {
        setDtCadastro(LocalDateTime.now());
    }

	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


}
