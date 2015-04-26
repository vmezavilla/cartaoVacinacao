package br.vacinacao.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.dao.ReCartaoVacinaDAO;
import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.ReCartaoVacina;
import br.vacinacao.interceptor.ContextDataInterceptor;

@Stateless
@Local(ReCartaoVacinaBeanInterface.class)
@Interceptors({ContextDataInterceptor.class})
public class ReCartaoVacinaBean implements ReCartaoVacinaBeanInterface{

	@Inject
	private ReCartaoVacinaDAO reCartaoVacinaDAO;
	
	@Override
	public ReCartaoVacina salvarReCartaoVacina(ReCartaoVacina reCartaoVacina) throws BeanException {
		try{
			return reCartaoVacinaDAO.salvarReCartaoVacina(reCartaoVacina);
		}catch (DaoException e){
			throw new BeanException(e);
		}
	}
	
}
