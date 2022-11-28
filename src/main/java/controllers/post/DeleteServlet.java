package controllers.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BO.PostBO;
import models.Bean.Post;

@WebServlet("/posts/delete")
public class DeleteServlet extends HttpServlet {
	private PostBO postBO;
	public DeleteServlet() {
		postBO = new PostBO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Post post = postBO.getById(id);
		if (post == null) {
			response.sendRedirect("/page-not-found");
		}
	}

}
