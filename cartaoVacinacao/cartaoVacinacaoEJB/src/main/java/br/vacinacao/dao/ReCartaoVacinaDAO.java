package br.vacinacao.dao;

import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.ReCartaoVacina;

public class ReCartaoVacinaDAO extends Dao<ReCartaoVacina>{

	StringBuffer sql;
	
	public ReCartaoVacinaDAO() {
		super(ReCartaoVacina.class);
	}
	
	public ReCartaoVacina salvarReCartaoVacina(ReCartaoVacina reCartaoVacina) throws DaoException{
		try{
			if(null != reCartaoVacina.getId()){
				reCartaoVacina = atualiza(reCartaoVacina);
			}else{
				adiciona(reCartaoVacina);
			}
			return reCartaoVacina;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
}
