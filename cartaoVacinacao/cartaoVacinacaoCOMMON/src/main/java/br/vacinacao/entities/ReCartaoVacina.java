package br.vacinacao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "re_cartao_vacina", schema = "cartaovacinacao")
public class ReCartaoVacina implements Serializable{

	private static final long serialVersionUID = -3462480073041582676L;
	
	@EmbeddedId
	private ReCartaoVacinaPK id;
	
	@Column(name = "dtAplicacao")
	private Date dtAplicacao;

	public ReCartaoVacinaPK getId() {
		return id;
	}
	public void setId(ReCartaoVacinaPK id) {
		this.id = id;
	}
	public Date getDtAplicacao() {
		return dtAplicacao;
	}
	public void setDtAplicacao(Date dtAplicacao) {
		this.dtAplicacao = dtAplicacao;
	}
}
