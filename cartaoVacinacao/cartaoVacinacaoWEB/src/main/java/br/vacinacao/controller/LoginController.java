package br.vacinacao.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.vacinacao.bean.UsuarioBeanInterface;
import br.vacinacao.bean.exception.BeanException;
import br.vacinacao.entities.Usuario;
import br.vacinacao.form.LoginForm;


/**
 *  Classe Controle da tela de Login
 *  
 * @author Victor Mezavilla
 */

@ManagedBean
public class LoginController extends GenericController implements Serializable {

	private static final long serialVersionUID = -1559937944856580199L;
	
	@EJB
	private UsuarioBeanInterface usuarioBean;

	private LoginForm form;

	/**
	 * Metodo para recuperar o formulario da tela
	 */
	public LoginForm getForm() {
		if (form == null) {
			form = new LoginForm();
		}
		return form;
	}
	
	@PostConstruct
	public void init(){
		form = null;
	}
	
	public void cadastrarUsuario(){
		Usuario usuario = popularUsuario();
		try {
			usuarioBean.salvarUsuario(usuario);
			exibirMensagem(FacesMessage.SEVERITY_INFO, "display.operacao.realizada.sucesso");
		} catch (BeanException e) {
			e.printStackTrace();
		}
	}
	
	private Usuario popularUsuario() {
		Usuario usuario = new Usuario();
		usuario.setUsuario(getForm().getUsuario());
		usuario.setSenha(getForm().getSenha());
		return usuario;
	}

	public void logar(){
		try {
			Usuario usuario = usuarioBean.buscarUsuario(popularUsuario());
			if(usuario.getId() != null){
				exibirMensagem(FacesMessage.SEVERITY_INFO, "display.usuario.senha.invalido");
			}else{
				exibirMensagem(FacesMessage.SEVERITY_WARN, "display.usuario.senha.invalido");
				init();
			}
		} catch (BeanException e) {
			getLogger().error("",e);
			exibirMensagemErro( "display.operacao.realizada.sucesso");
		}
	}
	
}
