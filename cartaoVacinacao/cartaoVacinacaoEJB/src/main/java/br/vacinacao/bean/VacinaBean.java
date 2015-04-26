package br.vacinacao.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.dao.VacinaDAO;
import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.Vacina;
import br.vacinacao.interceptor.ContextDataInterceptor;

@Stateless
@Local(VacinaBeanInterface.class)
@Interceptors({ContextDataInterceptor.class})
public class VacinaBean implements VacinaBeanInterface{

	@Inject
	private VacinaDAO vacinaDAO;
	
	@Override
	public Vacina salvarVacina(Vacina vacina) throws BeanException {
		try{
			return vacinaDAO.salvarVacina(vacina);
		}catch (DaoException e){
			throw new BeanException(e);
		}
	}
	
}
