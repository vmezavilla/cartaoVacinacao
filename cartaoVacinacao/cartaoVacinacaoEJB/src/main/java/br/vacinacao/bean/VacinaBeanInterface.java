package br.vacinacao.bean;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.entities.Vacina;

public interface VacinaBeanInterface {

	abstract Vacina salvarVacina(Vacina vacina) throws BeanException;
}
