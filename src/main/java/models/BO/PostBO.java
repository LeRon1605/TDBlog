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
}
