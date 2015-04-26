package br.vacinacao.dao;

import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.Vacina;

public class VacinaDAO extends Dao<Vacina>{

	StringBuffer sql;
	
	public VacinaDAO() {
		super(Vacina.class);
	}
	
	public Vacina salvarVacina(Vacina vacina) throws DaoException{
		try{
			if(null != vacina.getId()){
				vacina = atualiza(vacina);
			}else{
				adiciona(vacina);
			}
			return vacina;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
}
