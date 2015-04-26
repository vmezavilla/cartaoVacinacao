package br.vacinacao.bean;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.entities.Crianca;

public interface CriancaBeanInterface {

	abstract Crianca salvarCrianca(Crianca crianca) throws BeanException;
}
