package br.vacinacao.dao;

import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.ReOcorrenciaReacao;

public class ReOcorrenciaReacaoDAO extends Dao<ReOcorrenciaReacao>{

	StringBuffer sql;
	
	public ReOcorrenciaReacaoDAO() {
		super(ReOcorrenciaReacao.class);
	}
	
	public ReOcorrenciaReacao salvarReOcorrenciaReacao(ReOcorrenciaReacao reOcorrenciaReacao) throws DaoException{
		try{
			if(null != reOcorrenciaReacao.getId()){
				reOcorrenciaReacao = atualiza(reOcorrenciaReacao);
			}else{
				adiciona(reOcorrenciaReacao);
			}
			return reOcorrenciaReacao;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
}
