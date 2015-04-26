package br.vacinacao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acompanhamento", schema = "cartaovacinacao")
public class Acompanhamento implements Serializable{

	private static final long serialVersionUID = 8166228408681014467L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAcompanhamento")
	private Long id;
	
	@Column(name = "peso")
	private Integer peso;
	
	@Column(name = "altura")
	private Integer altura;
	
	@Column(name = "dtAcompanhamento")
	private Date dtAcompanhamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCrianca")
	private Crianca crianca;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public Date getDtAcompanhamento() {
		return dtAcompanhamento;
	}
	public void setDtAcompanhamento(Date dtAcompanhamento) {
		this.dtAcompanhamento = dtAcompanhamento;
	}
	public Crianca getCrianca() {
		return crianca;
	}
	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}
}
