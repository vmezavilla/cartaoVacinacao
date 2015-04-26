package br.vacinacao.bean;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.entities.ReCartaoVacina;

public interface ReCartaoVacinaBeanInterface {

	abstract ReCartaoVacina salvarReCartaoVacina(ReCartaoVacina reCartaoVacina) throws BeanException;
}
