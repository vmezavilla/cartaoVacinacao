package br.vacinacao.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.dao.AcompanhamentoDAO;
import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.Acompanhamento;
import br.vacinacao.interceptor.ContextDataInterceptor;

@Stateless
@Local(AcompanhamentoBeanInterface.class)
@Interceptors({ContextDataInterceptor.class})
public class AcompanhamentoBean implements AcompanhamentoBeanInterface{

	@Inject
	private AcompanhamentoDAO acompanhamentoDAO;
	
	@Override
	public Acompanhamento salvarAcompanhamento(Acompanhamento acompanhamento) throws BeanException {
		try{
			return acompanhamentoDAO.salvarAcompanhamento(acompanhamento);
		}catch (DaoException e){
			throw new BeanException(e);
		}
	}
	
}
