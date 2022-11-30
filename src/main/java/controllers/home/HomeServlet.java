package controllers.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BaseServlet;
import core.Auth.Claim;
import models.BO.PostBO;
import models.Bean.Post;
import models.Bean.User;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends BaseServlet{
	private PostBO postBO;
	
	public HomeServlet() {
		postBO = new PostBO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		ArrayList<Post> posts = postBO.getAllWithPostAndAuthor();
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/views/home/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
