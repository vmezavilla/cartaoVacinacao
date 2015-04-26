package br.vacinacao.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.dao.ReOcorrenciaReacaoDAO;
import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.ReOcorrenciaReacao;
import br.vacinacao.interceptor.ContextDataInterceptor;

@Stateless
@Local(ReOcorrenciaReacaoBeanInterface.class)
@Interceptors({ContextDataInterceptor.class})
public class ReOcorrenciaReacaoBean implements ReOcorrenciaReacaoBeanInterface{

	@Inject
	private ReOcorrenciaReacaoDAO reOcorrenciaReacaoDAO;
	
	@Override
	public ReOcorrenciaReacao salvarReOcorrenciaReacao(ReOcorrenciaReacao reOcorrenciaReacao) throws BeanException {
		try{
			return reOcorrenciaReacaoDAO.salvarReOcorrenciaReacao(reOcorrenciaReacao);
		}catch (DaoException e){
			throw new BeanException(e);
		}
	}
	
}
