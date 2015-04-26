package br.vacinacao.dao;

import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.Acompanhamento;

public class AcompanhamentoDAO extends Dao<Acompanhamento>{

	StringBuffer sql;
	
	public AcompanhamentoDAO() {
		super(Acompanhamento.class);
	}
	
	public Acompanhamento salvarAcompanhamento(Acompanhamento acompanhamento) throws DaoException{
		try{
			if(null != acompanhamento.getId()){
				acompanhamento = atualiza(acompanhamento);
			}else{
				adiciona(acompanhamento);
			}
			return acompanhamento;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
}
