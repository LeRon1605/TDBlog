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
import javax.servlet.http.HttpServletResponse;

import core.Auth.AuthContext;

@WebFilter(urlPatterns = {"/admin", "/posts/insert", "/posts/update", "/posts/delete, /me/posts"})
public class AuthorizationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		AuthContext context = new AuthContext((HttpServletRequest)request);
		if (!context.isAuthenticated())
			((HttpServletResponse)response).sendRedirect("/auth/login");
		else 
			if (((HttpServletRequest)request).getServletPath().startsWith("/admin")){
				if (!context.isInRole("ADMIN")) {
					request.getRequestDispatcher("/views/errors/unauthorized.jsp").forward(request, response);
				}else {
					chain.doFilter(request, response);
				}
			}else {
				chain.doFilter(request, response);
			}
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
