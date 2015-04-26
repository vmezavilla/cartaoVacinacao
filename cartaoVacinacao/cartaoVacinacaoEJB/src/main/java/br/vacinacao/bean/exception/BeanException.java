package br.vacinacao.bean.exception;

import javax.ejb.ApplicationException;

import br.vacinacao.dao.exception.DaoException;

@ApplicationException(rollback=true)
public class BeanException extends Exception {

	private static final long serialVersionUID = -5009931154989658597L;

	public BeanException(String string) {
		super(string);
	}
	
	
	
	public BeanException(String string, Throwable cause) {
		super(string, cause);
	}

	public BeanException(DaoException e) {
		super(e);
	}
}