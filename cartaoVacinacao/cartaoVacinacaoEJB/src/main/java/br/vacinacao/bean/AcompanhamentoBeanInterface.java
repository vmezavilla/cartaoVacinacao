package br.vacinacao.bean;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.entities.Acompanhamento;

public interface AcompanhamentoBeanInterface {

	abstract Acompanhamento salvarAcompanhamento(Acompanhamento acompanhamento) throws BeanException;
}
