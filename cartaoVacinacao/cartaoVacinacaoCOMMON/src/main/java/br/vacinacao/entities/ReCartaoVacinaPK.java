package br.vacinacao.entities;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ReCartaoVacinaPK implements Serializable{

	private static final long serialVersionUID = -187273502579684104L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCartao")
	private CartaoVacinacao cartaoVacinacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVacina")
	private Vacina vacina;
	

	public CartaoVacinacao getCartaoVacinacao() {
		return cartaoVacinacao;
	}

	public void setCartaoVacinacao(CartaoVacinacao cartaoVacinacao) {
		this.cartaoVacinacao = cartaoVacinacao;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

}
