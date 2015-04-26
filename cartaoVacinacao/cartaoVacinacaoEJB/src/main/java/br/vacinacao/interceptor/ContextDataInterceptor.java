package br.vacinacao.interceptor;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import br.vacinacao.common.Constant;

/**
 * Implementa interceptador que armazenará no MDC do LOG4J o login do usuário para que apareça nos arquivos de logging
 * da aplicação
 * 
 * @author fabiano.nascimento
 * 
 */
public class ContextDataInterceptor {

    private Logger logger = LoggerFactory.getLogger(ContextDataInterceptor.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss,SSS Z");

    /***
     * Faz logs em nível debug registrando classe do EJB, método, parâmetros e resultado (ou exceção) chamados. Além de
     * setar o MDC do SL4J com o idLogin para ficar disponível aos demais níveis de logging que espera-se que sejam
     * realizados pelas classes originárias
     * 
     * @param context
     * @return
     * @throws Exception
     */
    @AroundInvoke
    public Object setContextData(InvocationContext context) throws Exception {
        // Capturando do contexto o valor do item "idLogin", caso não tenha sido passado pelo cliente do EJB será setado
        // como NULL
        Object login = context.getContextData().get(Constant.CONTEXTDATA_LOGIN_NAME);
        if (login != null) {
            MDC.put(Constant.CONTEXTDATA_LOGIN_NAME, login.toString());
        }

        // Monta mensagem de logging
        Object resultado = null;
        try {
            resultado = context.proceed();
        } catch (Throwable t) {
            this.logger.error(String.format("%s.%s(%s) = %s", context.getTarget().getClass().getName(), context
                    .getMethod().getName(), this.getParameters(context.getParameters()), t.getClass()
                    .getCanonicalName()), t);
            throw new Exception(t);
        }
        // Só invoca os métodos se estiver no nível de debug para não haver procesamento desnecessário
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("{}.{}({}) ===> {}", context.getTarget().getClass().getSimpleName(), context.getMethod()
                    .getName(), this.getParameters(context.getParameters()), this.getResultado(resultado));
        }
        return resultado;
    }

    /**
     * Transforma o array de objetos em uma representação em string separados por vírgula
     * 
     * @param params
     *            Parâmetros a serem objetidas as representações em string
     * 
     * @return String para log
     */
    private String getParameters(Object[] params) {
        StringBuilder sb = new StringBuilder();
        for (short i = 0; i < params.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            if (params[i] instanceof Calendar) {
                sb.append(dateFormat.format(((Calendar) params[i]).getTime()));
            } else if (params[i] instanceof String) {
                sb.append("\"").append(params[i]).append("\"");
            } else {
                sb.append(String.valueOf(params[i]));
            }
        }
        return sb.toString();
    }

    /**
     * Transforma objeto em uma representação em string
     * 
     * @param o
     *            Objeto a ser transformado
     * 
     * @return String que representa o objeto
     */
    @SuppressWarnings("rawtypes")
    private String getResultado(Object o) {
        StringBuilder sb = new StringBuilder();
        if (o == null) {
            sb.append("NULL");
        } else {
            if (o instanceof Object[] || o.getClass().isArray()) {
                sb.append(o.getClass().getComponentType()).append("[").append(Array.getLength(o)).append("]");
            } else if (Collection.class.isInstance(o)) {
                sb.append(o.getClass().getCanonicalName()).append("[").append(((Collection) o).size()).append("]");
            } else if (o instanceof Calendar) {
                sb.append(dateFormat.format(((Calendar) o).getTime()));
            } else {
                sb.append(String.valueOf(o));
            }
        }
        return sb.toString();
    }


}
