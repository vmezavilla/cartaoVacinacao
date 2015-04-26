package br.vacinacao.bean;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.entities.ReOcorrenciaReacao;

public interface ReOcorrenciaReacaoBeanInterface {

	abstract ReOcorrenciaReacao salvarReOcorrenciaReacao(ReOcorrenciaReacao reOcorrenciaReacao) throws BeanException;
}
