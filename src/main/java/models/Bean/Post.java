package models.Bean;

import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Post {
	private String ID;
	@NotNull(message = "Tên bài viết không được để trống")
	@Size(min = 15, message = "Tên bài viết có độ dài tối thiểu 15 kí tự")
	private String name;
	@NotNull(message = "Nội dung của bài viết không được để trống")
	@Size(min = 100, message = "Nội dung bài viết có độ dài tối thiểu 100 kí tự")
	private String content;
	private int viewCount;
	private int totalTime;
	private String image;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	@NotNull(message = "Tác giả bài viết không được để trống")
	private String authorID;
	private String author;
	@NotNull(message = "Thể loại bài viết không được để trống")
	private String tagID;
	private String tag;
	private String state;
	
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
	public String getState() {
		return state;
	}
	public String getImage() {
		return image;
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
	public void setState(String state) {
		this.state = state;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
