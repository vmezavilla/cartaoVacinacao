package br.vacinacao.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario", schema = "cartaovacinacao")
public class Usuario implements Serializable{

	private static final long serialVersionUID = -8757968470368707640L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long id;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "senha")
	private String senha;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario", insertable = false, updatable = false)
	private Set<Crianca> criancas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Set<Crianca> getCriancas() {
		return criancas;
	}
	public void setCriancas(Set<Crianca> criancas) {
		this.criancas = criancas;
	}
}
