package br.vacinacao.interceptor;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import br.vacinacao.common.Constant;



@WebFilter("/ContextDataFilter")
public class ContextDataFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(ContextDataFilter.class);

    /**
     * Default constructor.
     */
    public ContextDataFilter() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        /***
         * Because the MDC is thread-local and every request in a web application has it’s own thread, you have to put
         * the sessionID into the MDC at the beginning of each request. You can do this by using a servlet filter.
         */

        HttpSession session = ((HttpServletRequest) request).getSession();
        Object login = session.getAttribute(Constant.CONTEXTDATA_LOGIN_NAME);
        if (login != null && login instanceof Principal) {
            MDC.put(Constant.CONTEXTDATA_LOGIN_NAME, login.toString());
        } else {
            logger.debug("Variável de sessão 'userLogin' = {}", login == null ? "NULL"
                    : login.getClass().getCanonicalName());
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
