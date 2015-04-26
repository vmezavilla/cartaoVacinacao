package br.vacinacao.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.vacinacao.dao.exception.DaoException;
import br.vacinacao.entities.Usuario;

public class UsuarioDAO extends Dao<Usuario>{

	StringBuffer sql;
	
	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public Usuario salvarUsuario(Usuario usuario) throws DaoException{
		try{
			if(null != usuario.getId()){
				usuario = atualiza(usuario);
			}else{
				adiciona(usuario);
			}
			return usuario;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Usuario buscarUsuario(Usuario usuario) throws DaoException{
		
		try{
			sql = new StringBuffer();
			
			sql.append("select distinct u from Usuario u ")
			.append(" left join fetch u.criancas c ")
			.append(" where")
			.append(" u.usuario = :usuario ")
			.append(" and")
			.append(" u.senha = :senha ");
			
			Query query = manager.createQuery(sql.toString());
			query.setParameter("usuario", usuario.getUsuario());
			query.setParameter("senha", usuario.getSenha());
			
			
			usuario = (Usuario) query.getSingleResult();
			
		} catch (NoResultException e) {
			usuario = new Usuario();
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return usuario;
	}
	
}
