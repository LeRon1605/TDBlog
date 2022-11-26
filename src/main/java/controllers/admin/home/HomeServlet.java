package controllers.admin.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BaseServlet;
import models.BO.PostBO;
import models.Bean.Post;

@WebServlet(urlPatterns = "/admin")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private PostBO postBO;
	public HomeServlet() {
		postBO = new PostBO();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		ArrayList<Post> posts = postBO.getAllWithPostAndAuthor();
		
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/views/admin/home/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
