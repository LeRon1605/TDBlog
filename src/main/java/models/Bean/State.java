package models.Bean;

import java.sql.Timestamp;

import models.Bean.Common.PostState;

public class State {
	private String id;
	private PostState state;
	private Timestamp at;
	private String postID;
	
	public String getId() {
		return id;
	}
	public PostState getState() {
		return state;
	}
	public int getStateRaw() {
		if (state == PostState.Pending)
			return 0;
		else if (state == PostState.Publish)
			return 1;
		else 
			return 2;
	}
	public String getStateStr() {
		if (state == PostState.Pending)
			return "Đang chờ duyệt";
		else if (state == PostState.Publish)
			return "Đang phát hành";
		else
			return "Đã bị cấm";
	}
	public Timestamp getAt() {
		return at;
	}
	public String getPostID() {
		return postID;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setState(PostState state) {
		this.state = state;
	}
	public void setAt(Timestamp at) {
		this.at = at;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	
}
