package br.vacinacao.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "re_ocorrencia_reacao", schema = "cartaovacinacao")
public class ReOcorrenciaReacao implements Serializable{

	private static final long serialVersionUID = 6139935560723011518L;

	@EmbeddedId
	private ReOcorrenciaReacaoPk id;

	public ReOcorrenciaReacaoPk getId() {
		return id;
	}

	public void setId(ReOcorrenciaReacaoPk id) {
		this.id = id;
	}
}
