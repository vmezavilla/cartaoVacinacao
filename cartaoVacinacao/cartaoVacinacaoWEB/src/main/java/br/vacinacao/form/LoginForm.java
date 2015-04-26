package br.vacinacao.form;

import java.io.Serializable;

public class LoginForm implements Serializable{
	
	private static final long serialVersionUID = 7317387401507699620L;
	
	private String usuario;
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
