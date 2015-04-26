package br.vacinacao.dao;

import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.Crianca;

public class CriancaDAO extends Dao<Crianca>{

	StringBuffer sql;
	
	public CriancaDAO() {
		super(Crianca.class);
	}
	
	public Crianca salvarCrianca(Crianca crianca) throws DaoException{
		try{
			if(null != crianca.getId()){
				crianca = atualiza(crianca);
			}else{
				adiciona(crianca);
			}
			return crianca;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
}
