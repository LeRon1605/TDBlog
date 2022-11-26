package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import core.Auth.AuthContext;

@WebFilter(urlPatterns = {"/admin"})
public class AuthorizationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		AuthContext context = new AuthContext((HttpServletRequest)request);
		if (!context.isAuthenticated())
			request.getRequestDispatcher("/views/errors/unauthorized.jsp").forward(request, response);
		if (((HttpServletRequest)request).getServletPath().startsWith("/admin")){
			if (!context.isInRole("Admin")) {
				request.getRequestDispatcher("/views/errors/unauthorized.jsp").forward(request, response);
			}
		}
			
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
