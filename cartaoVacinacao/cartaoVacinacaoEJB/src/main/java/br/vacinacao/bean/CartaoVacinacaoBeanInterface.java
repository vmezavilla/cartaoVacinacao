package br.vacinacao.bean;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.entities.CartaoVacinacao;

public interface CartaoVacinacaoBeanInterface {

	abstract CartaoVacinacao salvarCartaoVacinacao(CartaoVacinacao cartaoVacinacao) throws BeanException;
}
