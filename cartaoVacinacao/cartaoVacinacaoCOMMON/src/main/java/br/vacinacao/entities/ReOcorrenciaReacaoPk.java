package br.vacinacao.entities;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ReOcorrenciaReacaoPk implements Serializable{

	private static final long serialVersionUID = 6074360758829000214L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCrianca")
	private Crianca crianca;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVacina")
	private Vacina vacina;

	
	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
}
