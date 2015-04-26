package br.vacinacao.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.dao.CartaoVacinacaoDAO;
import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.CartaoVacinacao;
import br.vacinacao.interceptor.ContextDataInterceptor;

@Stateless
@Local(CartaoVacinacaoBeanInterface.class)
@Interceptors({ContextDataInterceptor.class})
public class CartaoVacinacaoBean implements CartaoVacinacaoBeanInterface{

	@Inject
	private CartaoVacinacaoDAO cartaoVacinacaoDAO;
	
	@Override
	public CartaoVacinacao salvarCartaoVacinacao(CartaoVacinacao cartaoVacinacao) throws BeanException {
		try{
			return cartaoVacinacaoDAO.salvarCartaoVacinacao(cartaoVacinacao);
		}catch (DaoException e){
			throw new BeanException(e);
		}
	}
	
}
