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
@Table(name = "tb_vacina", schema = "cartaovacinacao")
public class Vacina implements Serializable{

	private static final long serialVersionUID = -7731577178140984278L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVacina")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Set<ReCartaoVacina> cartaoVacinas;

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

	public Set<ReCartaoVacina> getCartaoVacinas() {
		return cartaoVacinas;
	}

	public void setCartaoVacinas(Set<ReCartaoVacina> cartaoVacinas) {
		this.cartaoVacinas = cartaoVacinas;
	}
	
}
