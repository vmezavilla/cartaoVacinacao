package br.vacinacao.bean;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.entities.Usuario;

public interface UsuarioBeanInterface {

	abstract Usuario salvarUsuario(Usuario usuario) throws BeanException;
	abstract Usuario buscarUsuario(Usuario usuario) throws BeanException;
}
