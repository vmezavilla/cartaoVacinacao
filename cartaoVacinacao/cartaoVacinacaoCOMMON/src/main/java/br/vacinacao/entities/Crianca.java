package br.vacinacao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_crianca", schema = "cartaovacinacao")
public class Crianca implements Serializable{

	private static final long serialVersionUID = 3356832960295109466L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCrianca")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "dtNascimento")
	private Date dtNascimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@OneToOne(fetch = FetchType.LAZY , mappedBy= "crianca" , optional=false)
	private CartaoVacinacao cartaoVacinacao;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCrianca", insertable = false, updatable = false)
	private Set<ReOcorrenciaReacao> ocorrenciaReacoes;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCrianca", insertable = false, updatable = false)
	private Set<Acompanhamento> acompanhamentos;
	
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public CartaoVacinacao getCartaoVacinacao() {
		return cartaoVacinacao;
	}
	public void setCartaoVacinacao(CartaoVacinacao cartaoVacinacao) {
		this.cartaoVacinacao = cartaoVacinacao;
	}
	public Set<ReOcorrenciaReacao> getOcorrenciaReacoes() {
		return ocorrenciaReacoes;
	}
	public void setOcorrenciaReacoes(Set<ReOcorrenciaReacao> ocorrenciaReacoes) {
		this.ocorrenciaReacoes = ocorrenciaReacoes;
	}
	public Set<Acompanhamento> getAcompanhamentos() {
		return acompanhamentos;
	}
	public void setAcompanhamentos(Set<Acompanhamento> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}
}
