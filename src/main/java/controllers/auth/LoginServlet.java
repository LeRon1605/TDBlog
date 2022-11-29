package controllers.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BaseServlet;
import core.Auth.Claim;
import models.BO.RoleBO;
import models.BO.UserBO;
import models.Bean.User;

@WebServlet(urlPatterns = "/auth/login")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserBO userBO;
	private RoleBO roleBO;
	public LoginServlet() {
		userBO = new UserBO();
		roleBO = new RoleBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		if (this.authContext.isAuthenticated()) {
			response.sendRedirect("/");
		}else {
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		if (this.authContext.isAuthenticated()) {
			response.sendRedirect("/");
		}else {
			String username = (String)request.getParameter("username");
			String password = (String)request.getParameter("password");
			
			User user = userBO.login(username, password);
			if (user == null) {
				request.setAttribute("error", "Người dùng không tồn tại");
				doGet(request, response);
			}else {
				boolean result = this.authContext.signIn(new Claim[] {
					new Claim("UserID", user.getID()),
					new Claim("Username", user.getUsername()),
					new Claim("Fullname", user.getName()),
					new Claim("Role", roleBO.getById(user.getRoleID()).getName())
				});
				if (result)
					response.sendRedirect("/home");
				else
				{
					request.setAttribute("error", "Đăng nhập không thành công");
					doGet(request, response);
				}
			}
		}
	}

}
