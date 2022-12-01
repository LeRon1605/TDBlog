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

@WebServlet("/posts/publish")
public class PublishServlet extends BaseServlet {
	private PostBO postBO;
    public PublishServlet() {
        postBO = new PostBO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		if (this.authContext.isInRole("ADMIN")) {
			String id = request.getParameter("id");
			if (id == null)
				response.sendRedirect("/page-not-found");
			else {
				Post post = postBO.getById(id);
				if (post == null)
					response.sendRedirect("/page-not-found");
				else {
					boolean result = postBO.publishPost(id);
					if (result) {
						response.sendRedirect("/posts/update?success=" + "Success publish this post&id=" + post.getID());
					}else {
						response.sendRedirect("/posts/update?error=" + "Something went wrong&id=" + post.getID());
					}
				}
			}
		}else {
			request.getRequestDispatcher("/views/errors/unauthorized.jsp").forward(request, response);
		}
	}

}
