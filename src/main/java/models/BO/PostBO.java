package models.BO;

import java.util.ArrayList;

import models.Bean.Post;
import models.DAO.PostDAO;

public class PostBO {
	private PostDAO postDAO;
	public PostBO() {
		postDAO = new PostDAO();
	}
	
	public ArrayList<Post> getAllWithPostAndAuthor() {
		return postDAO.getAllWithPostAndAuthor();
	}
	
	public boolean updateView(String id, int view) {
		if (id == null || id.isEmpty()) {
			return false;
		}
		Post post = postDAO.getById(id);
		if (post == null) {
			return false;
		}
		return postDAO.updateView(id, post.getViewCount() + view);
	}
	public Post getById(String id) {
		return postDAO.getById(id);
	}
	public boolean deletePost(String id) {
		if (id == null || id.isEmpty()) {
			return false;
		}
		Post post = postDAO.getById(id);
		if (post == null) {
			return false;
		}
		return postDAO.deletePost(id);
	}
	public Post getWithTagAndAuthor(String id) {
		return postDAO.getWithTagAndAuthor(id);
	}
}
