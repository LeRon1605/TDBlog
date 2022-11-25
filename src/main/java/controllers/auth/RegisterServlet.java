package controllers.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BaseServlet;
import models.BO.UserBO;
import models.Bean.User;

@WebServlet(urlPatterns = "/auth/register")
public class RegisterServlet extends BaseServlet{
	private UserBO userBO;
	public RegisterServlet() {
		userBO = new UserBO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		if (this.authContext.isAuthenticated()) {
			resp.sendRedirect("/home/index");
		}else {
			req.getRequestDispatcher("/views/auth/register.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		if (this.authContext.isAuthenticated()) {
			resp.sendRedirect("/home/index");
		}else {
			User user = new User();
			user.setName((String)req.getParameter("name"));
			user.setUsername((String)req.getParameter("username"));
			user.setPassword((String)req.getParameter("password"));
			
			boolean result = userBO.register(user);
			
			if (result == false) {
				req.setAttribute("error", "Tài khoản đã tồn tại");
				doGet(req, resp);
			}else {
				resp.sendRedirect("/auth/login");
			}
		}
	}
}
