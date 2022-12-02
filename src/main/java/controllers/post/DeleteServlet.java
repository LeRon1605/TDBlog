package controllers.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BaseServlet;
import models.BO.PostBO;
import models.Bean.Post;

@WebServlet("/posts/delete")
public class DeleteServlet extends BaseServlet {
	private PostBO postBO;
	public DeleteServlet() {
		postBO = new PostBO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String id = request.getParameter("id");
		String returnUrl = request.getParameter("returnUrl");
		Post post = postBO.getById(id);
		if (post == null) {
			response.sendRedirect("/page-not-found");
		}else {
			if (this.authContext.isAuthenticated() && (this.authContext.isInRole("ADMIN") || this.authContext.getClaim("UserID").getValue().equals(post.getAuthorID()))) {
				boolean result = postBO.deletePost(id);
				if (result) {
					response.sendRedirect(returnUrl);
				}else {
					response.sendRedirect("/page-not-found");
				}
			}else {
				request.getRequestDispatcher("/views/errors/unauthorized.jsp").forward(request, response);
			}
		}
	}

}
