package br.vacinacao.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.dao.CriancaDAO;
import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.Crianca;
import br.vacinacao.interceptor.ContextDataInterceptor;

@Stateless
@Local(CriancaBeanInterface.class)
@Interceptors({ContextDataInterceptor.class})
public class CriancaBean implements CriancaBeanInterface{

	@Inject
	private CriancaDAO criancaDAO;
	
	@Override
	public Crianca salvarCrianca(Crianca crianca) throws BeanException {
		try{
			return criancaDAO.salvarCrianca(crianca);
		}catch (DaoException e){
			throw new BeanException(e);
		}
	}
	
}
