package models.Bean;

import java.sql.Timestamp;

public class Post {
	private String ID;
	private String name;
	private String content;
	private int viewCount;
	private int totalTime;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private String authorID;
	private String author;
	private String tagID;
	private String tag;
	
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getContent() {
		return content;
	}
	public int getViewCount() {
		return viewCount;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public String getAuthorID() {
		return authorID;
	}
	public String getAuthor() {
		return author;
	}
	public String getTagID() {
		return tagID;
	}
	public String getTag() {
		return tag;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public void setTagID(String tagID) {
		this.tagID = tagID;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
