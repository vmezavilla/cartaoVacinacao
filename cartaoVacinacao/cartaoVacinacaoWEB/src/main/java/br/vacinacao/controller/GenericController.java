package br.vacinacao.controller;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericController {

	private ResourceBundle bundle;

	private Logger logger;

	private Class<? extends GenericController> controller;

	public GenericController() {
		this.controller = getClass();
	}

	@PostConstruct
	public void init() {
//		try {
//			ExternalContext ec = FacesContext.getCurrentInstance()
//					.getExternalContext();
//				ec.redirect(ec.getRequestContextPath() + "/login/login.jsf");
//		} catch (IOException e) {
//			logger.error("",e);
//		}
	}

	protected void exibirMensagem(Severity severity, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(severity, getValue(mensagem),getValue(mensagem)));
	}

	protected void exibirMensagemErro(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, getValue(mensagem), getValue(mensagem)));
	}

	protected void exibirMensagemComParametros(Severity severity,
			String mensagem, Object[] params) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(severity, getValue(mensagem),getValue(mensagem)));
	}

	protected void exibirMensagemErroComParametros(String mensagem,
			Object[] params) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, getValue(mensagem, params), getValue(mensagem, params)));
	}

	protected ResourceBundle getBundle() {
		if (bundle == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			bundle = context.getApplication().getResourceBundle(context, "msg");
		}
		return bundle;
	}

	protected Logger getLogger() {
		if (null == logger) {
			logger = LoggerFactory.getLogger(controller);
		}
		return logger;
	}

	protected String getValue(String key) {

		String result = null;
		try {
			result = getBundle().getString(key);
		} catch (MissingResourceException e) {
			result = "???" + key + "??? not found";
		}
		return result;
	}

	public String getValue(String key, Object params[]) {

		String result = null;
		try {
			result = getBundle().getString(key);
		} catch (MissingResourceException e) {
			result = "???" + key + "??? not found";
		}

		if (params != null) {
			MessageFormat mf = new MessageFormat(result);
			result = mf.format(params, new StringBuffer(), null).toString();
		}

		return result;
	}

}
