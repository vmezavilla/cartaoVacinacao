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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cartao_vacinacao", schema = "cartaovacinacao")
public class CartaoVacinacao implements Serializable{

	private static final long serialVersionUID = -2638425890773675425L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCartao")
	private Long id;
	
	@OneToOne
	private Crianca crianca;
	
	@Column(name = "dtCartao")
	private Date dtCartao;
	

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCartao", insertable = false, updatable = false)
	private Set<ReCartaoVacina> cartaoVacinas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Crianca getCrianca() {
		return crianca;
	}
	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}
	public Date getDtCartao() {
		return dtCartao;
	}
	public void setDtCartao(Date dtCartao) {
		this.dtCartao = dtCartao;
	}
	public Set<ReCartaoVacina> getCartaoVacinas() {
		return cartaoVacinas;
	}
	public void setCartaoVacinas(Set<ReCartaoVacina> cartaoVacinas) {
		this.cartaoVacinas = cartaoVacinas;
	}
	
}
