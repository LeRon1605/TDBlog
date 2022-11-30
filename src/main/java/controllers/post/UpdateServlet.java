package controllers.post;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Validator.ValidateResult;
import core.Validator.Validator;
import models.BO.PostBO;
import models.BO.TagBO;
import models.Bean.Post;
import models.Bean.Tag;

@WebServlet("/posts/insert")
public class UpdateServlet extends HttpServlet {
	private TagBO tagBO;
	private PostBO postBO;
	public UpdateServlet() {
		tagBO = new TagBO();
		postBO = new PostBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Tag> tags = tagBO.getAll();
		String id = request.getParameter("id");
		Post post = postBO.getById(id);
		if(post != null) {
			request.setAttribute("tags", tags);
			request.getRequestDispatcher("/views/post/insert.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/admin/home/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		request.setCharacterEncoding("utf-8");
		
		String name = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		String tagID = (String)request.getParameter("tag");
		String id = request.getParameter("id");
		Post post = postBO.getById(id);
		
		if(post == null) {
			response.sendRedirect("/page-not-found");
		}
		else {
			post.setName(name);
			post.setContent(content);
			post.setTagID(tagID);
		}
		
		ValidateResult modelState = Validator.validate(post);
		if (modelState.isFailure()) {
			request.setAttribute("validation-error", modelState.getMessages());
			doGet(request, response);
		}else {
			boolean result = postBO.updatePost(post);
			if (result) {
				request.setAttribute("success", true);
			}else {
				request.setAttribute("error", "Cập nhât bài viết thất bại");
			}
		}
		doGet(request, response);
	}

}
