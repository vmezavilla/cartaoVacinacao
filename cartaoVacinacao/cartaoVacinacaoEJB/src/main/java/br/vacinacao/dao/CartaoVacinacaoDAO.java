package br.vacinacao.dao;

import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.CartaoVacinacao;

public class CartaoVacinacaoDAO extends Dao<CartaoVacinacao>{

	StringBuffer sql;
	
	public CartaoVacinacaoDAO() {
		super(CartaoVacinacao.class);
	}
	
	public CartaoVacinacao salvarCartaoVacinacao(CartaoVacinacao cartaoVacinacao) throws DaoException{
		try{
			if(null != cartaoVacinacao.getId()){
				cartaoVacinacao = atualiza(cartaoVacinacao);
			}else{
				adiciona(cartaoVacinacao);
			}
			return cartaoVacinacao;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
}
