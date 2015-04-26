package br.vacinacao.dao.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = -6225345949448211784L;

	public DaoException() {
		super();		
	}

	public DaoException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);		
	}

	public DaoException(final String arg0) {
		super(arg0);		
	}

	public DaoException(final Throwable arg0) {
		super(arg0);		
	}
	
}