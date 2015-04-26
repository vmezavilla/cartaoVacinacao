package br.vacinacao.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.dao.UsuarioDAO;
import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.Usuario;
import br.vacinacao.interceptor.ContextDataInterceptor;

@Stateless
@Local(UsuarioBeanInterface.class)
@Interceptors({ContextDataInterceptor.class})
public class UsuarioBean implements UsuarioBeanInterface{

	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario salvarUsuario(Usuario usuario) throws BeanException {
		try{
			return usuarioDAO.salvarUsuario(usuario);
		}catch (DaoException e){
			throw new BeanException(e);
		}
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) throws BeanException {
		try{
			return usuarioDAO.buscarUsuario(usuario);
		}catch (DaoException e){
			throw new BeanException(e);
		}
	}
	
}
