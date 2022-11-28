package models.BO;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import models.Bean.Post;
import models.Bean.State;
import models.Bean.Common.PostState;
import models.DAO.PostDAO;
import models.DAO.StateDAO;

public class PostBO extends BaseBO{
	private PostDAO postDAO;
	private StateDAO stateDAO;
	public PostBO() {
		postDAO = new PostDAO();
		stateDAO = new StateDAO();
	}
	
	public ArrayList<Post> getByFilter(String keyword, int state, String sortBy) {
		ArrayList<Post> posts = new ArrayList<Post>();
		for (Post post: postDAO.getByFilter(keyword, sortBy)) {
			State s = stateDAO.getCurrentStateOfPost(post.getID());
			if (state == -1 || s.getStateRaw() == state) {
				post.setState(s.getStateStr());
				posts.add(post);
			}
		}
		return posts;
	}
	
	public ArrayList<Post> getAllWithPostAndAuthor() {
		ArrayList<Post> posts = postDAO.getAllWithPostAndAuthor();
		for (Post post: posts) {
			State state = stateDAO.getCurrentStateOfPost(post.getID());
			post.setState(state.getStateStr());
		}
		return posts;
	}
	
	public boolean add(Post post) {
		post.setID(generateID());
		post.setViewCount(0);
		post.setTotalTime(0);
		post.setCreatedAt(Timestamp.from(Instant.now()));		
		boolean result =  postDAO.add(post);
		if (result) {
			State state = new State();
			state.setId(generateID());
			state.setState(PostState.Pending);
			state.setPostID(post.getID());
			state.setAt(post.getCreatedAt());
			return stateDAO.add(state);
		}
		return false;
	}
}
