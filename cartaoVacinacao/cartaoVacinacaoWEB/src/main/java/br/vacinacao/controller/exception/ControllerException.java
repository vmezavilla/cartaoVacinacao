package br.vacinacao.controller.exception;

public class ControllerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2296799413233125490L;
	
	public ControllerException(){
		super();
	}
	
	public ControllerException(String message){
		super(message);
	}
	public ControllerException(Throwable cause){
		super(cause);
	}
	public ControllerException(String message, Throwable cause) {
	        super(message, cause);
	}

}