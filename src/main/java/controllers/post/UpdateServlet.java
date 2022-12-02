package controllers.post;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controllers.BaseServlet;
import core.Auth.AuthContext;
import core.Validator.ValidateResult;
import core.Validator.Validator;
import models.BO.PostBO;
import models.BO.TagBO;
import models.Bean.Post;
import models.Bean.Tag;

@WebServlet("/posts/update")
@MultipartConfig(
		fileSizeThreshold=1024*1024*10, 	// 10 MB 
		maxFileSize=1024*1024*50,      	// 50 MB
		maxRequestSize=1024*1024*100
)   
public class UpdateServlet extends BaseServlet {
	private TagBO tagBO;
	private PostBO postBO;
	public UpdateServlet() {
		tagBO = new TagBO();
		postBO = new PostBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		String id = request.getParameter("id");
		
		ArrayList<Tag> tags = tagBO.getAll();
		Post post = postBO.getWithStateById(id);
		
		if(post != null) {
			if (this.authContext.isInRole("ADMIN") || this.authContext.getClaim("UserID").getValue().equals(post.getAuthorID())) {
				request.setAttribute("post", post);
				request.setAttribute("tags", tags);
				request.getRequestDispatcher("/views/post/update.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/views/errors/unauthorized.jsp").forward(request, response);
			}
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
		String image = (String)request.getParameter("image");
		String id = request.getParameter("id");
		Post post = postBO.getById(id);

		if(post == null) {
			response.sendRedirect("/page-not-found");
		} else {
			if (this.authContext.isInRole("ADMIN") || this.authContext.getClaim("UserID").getValue().equals(post.getAuthorID())) {
				post.setName(name);
				post.setContent(content);
				post.setTagID(tagID);
				post.setImage(image);
				
				ValidateResult modelState = Validator.validate(post);
				if (modelState.isFailure()) {
					request.setAttribute("validation-error", modelState.getMessages());
					doGet(request, response);
				}else {
					Part inputFile = request.getPart("image");
				    String path = request.getServletContext().getRealPath("public/uploads") + "\\" + Paths.get(inputFile.getSubmittedFileName()).getFileName().toString();
				    inputFile.write(path);
				    post.setImage("/public/uploads/" + Paths.get(inputFile.getSubmittedFileName()).getFileName().toString());
					boolean result = postBO.updatePost(post);
					if (result) {
						request.setAttribute("success", "Cập nhật bài viết thành công");
					}else {
						request.setAttribute("error", "Cập nhât bài viết thất bại");
					}
					doGet(request, response);
				}
			}else {
				request.getRequestDispatcher("/views/errors/unauthorized.jsp").forward(request, response);
			}
		}
	}
}
