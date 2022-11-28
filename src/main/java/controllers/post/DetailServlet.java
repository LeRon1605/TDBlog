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

@WebServlet("/posts")
public class DetailServlet extends BaseServlet{
	private PostBO postBO;
	public DetailServlet() {
		postBO = new PostBO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Post post = postBO.getWithTagAndAuthor(id);
		if (post == null) {
			response.sendRedirect("/page-not-found");
		} else {
			request.setAttribute("post", post);
			postBO.updateView(id, 1);
			request.getRequestDispatcher("/views/post/detail.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
