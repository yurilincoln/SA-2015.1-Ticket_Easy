package br.senai.sc.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sc.mb.SessaoAdminMB;

@WebFilter(urlPatterns="/admin/*")
public class SessaoFilterAdmin implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		SessaoAdminMB sessaoAdminMB = (SessaoAdminMB) servletRequest.getSession().getAttribute("sessaoAdminMB");
		
		if(sessaoAdminMB == null || !sessaoAdminMB.isLogadoAdmin()){
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			servletResponse.sendRedirect(servletRequest.getContextPath()
					.concat("/loginadmin.xhtml"));
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
