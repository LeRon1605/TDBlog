package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Auth.SessionAuthContext;
import core.Auth.IAuthContext;

public abstract class BaseServlet extends HttpServlet {
	protected IAuthContext authContext;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		authContext = new SessionAuthContext(req);
		super.service(req, resp);
	}
}
