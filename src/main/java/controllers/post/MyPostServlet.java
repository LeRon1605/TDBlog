package controllers.post;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BaseServlet;
import models.BO.PostBO;
import models.Bean.Post;

@WebServlet("/me/posts")
public class MyPostServlet extends BaseServlet {
	private PostBO postBO;
	public MyPostServlet() {
		postBO = new PostBO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String authorId = this.authContext.getClaim("UserID").getValue();
		String sortBy = request.getParameter("sortBy") != null ? (String)request.getParameter("sortBy") : "";
		String keyword = request.getParameter("keyword") != null ? (String)request.getParameter("keyword") : "";
		int state = request.getParameter("state") != null ? Integer.parseInt(request.getParameter("state")) : -1;
		ArrayList<Post> posts = postBO.getByFilter(keyword, authorId, state, sortBy);
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/views/post/my-post.jsp").forward(request, response);
	}
}
