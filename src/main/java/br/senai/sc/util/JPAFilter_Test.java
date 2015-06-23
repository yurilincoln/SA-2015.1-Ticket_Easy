package br.senai.sc.util;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames="Faces Servlet")
public class JPAFilter_Test implements Filter {
	
	private static Logger logger;

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger = Logger.getLogger(this.getClass().getName());
		logger.info("Criou O EMF");
		JPAUtil_Test.createEntityManagerFactory();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.warning("Fechou O EMF");
		JPAUtil_Test.entityManagerFactoryClose();
	}
}
