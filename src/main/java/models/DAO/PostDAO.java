package models.DAO;

import java.util.ArrayList;

import core.Mapper.ResultSetMapper.PostResultSetMapper;
import models.Bean.Post;

public class PostDAO extends BaseDAO<Post>{
	public PostDAO() {
		super(new PostResultSetMapper());
	}
	
	public ArrayList<Post> getByFilter(String keyword, String authorId, String sortBy) {
		String query = """
				SELECT POST.*, USER.NAME AS 'AUTHOR', USER.AVATAR AS 'AVATAR' , TAG.NAME AS 'TAG' FROM POST INNER JOIN TAG
				ON POST.TAGID = TAG.ID
				INNER JOIN USER
				ON POST.AUTHORID = USER.ID	
		""";
		if (keyword != null && !keyword.isEmpty()) {
			query += " WHERE POST.NAME LIKE '%" + keyword + "%'";
		}
		if (authorId != null && !authorId.isEmpty()) {
			if (keyword != null && !keyword.isEmpty()) {
				query += " AND POST.AUTHORID = '" + authorId + "'";
			}else {
				query += " WHERE POST.AUTHORID = '" + authorId + "'";
			}
		}
		if (sortBy != null && !sortBy.isEmpty()) {
			query += " ORDER BY POST." + sortBy;
		}
		return this.getRecordArray(query);
	}
	
	public ArrayList<Post> getAllWithPostAndAuthor() {
		String query = """
				SELECT POST.*, USER.NAME AS 'AUTHOR', TAG.NAME AS 'TAG' FROM POST INNER JOIN TAG
				ON POST.TAGID = TAG.ID
				INNER JOIN USER
				ON POST.AUTHORID = USER.ID
		""";
		return this.getRecordArray(query);
	}
  
	public Post getWithTagAndAuthor(String id) {
		String query = """
				SELECT POST.*, USER.NAME AS 'AUTHOR', USER.AVATAR AS 'AVATAR' , TAG.NAME AS 'TAG' FROM POST INNER JOIN TAG
				ON POST.TAGID = TAG.ID
				INNER JOIN USER
				ON POST.AUTHORID = USER.ID 
				WHERE POST.ID = ?
		""";
		return this.getRecordSingle(query, new Object[] {id});
	}
	
	public Post getById(String id) {
		String query = "SELECT * FROM POST WHERE ID = ?";
		return this.getRecordSingle(query, new Object[] {id});
	}
  
	public boolean updateView(String id, int view) {
		String query = "UPDATE POST SET VIEW = ? WHERE ID = ?";
		return this.executeQuery(query, new Object[] {view, id});
	}
  
	public boolean deletePost(String id) {
		String query = "DELETE FROM POST WHERE ID = ?";
		return this.executeQuery(query, new Object[] {id});
	}
	
	public boolean add(Post post) {
		String query = """
				INSERT INTO POST(ID, NAME, CONTENT, IMAGE, VIEW, TIME, CREATEDAT, UPDATEDAT, AUTHORID, TAGID)
				VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
		""";
		return this.executeQuery(query, new Object[] { post.getID(), post.getName(), post.getContent(), post.getImage(), post.getViewCount(), post.getTotalTime(), post.getCreatedAt(), post.getUpdatedAt(), post.getAuthorID(), post.getTagID() });
	} 
	
	public boolean updatePost(Post post) {
		String query = """	
				UPDATE POST SET NAME = ?, IMAGE = ?, CONTENT = ?, UPDATEDAT = ?, TAGID = ?
				WHERE ID = ?;
		""";
		return this.executeQuery(query, new Object[] { post.getName(), post.getImage(), post.getContent(), post.getUpdatedAt(), post.getTagID(), post.getID() });
	}
	
	public ArrayList<Post> getByAuthor(String authorId) {
		String query = """
				SELECT POST.*, USER.NAME AS 'AUTHOR', TAG.NAME AS 'TAG' FROM POST INNER JOIN TAG
				ON POST.TAGID = TAG.ID
				INNER JOIN USER
				ON POST.AUTHORID = USER.ID
				WHERE AUTHORID = ?
		""";
		return this.getRecordArray(query, new Object[] { authorId });
	}
	
	public ArrayList<Post> getLastedPost() {
		return this.getRecordArray("""
				SELECT POST.*, TAG.NAME AS 'TAG', USER.NAME AS 'AUTHOR', USER.AVATAR AS 'AVATAR' FROM POST INNER JOIN
				(
					SELECT POST.ID, MAX(STATEHISTORY.AT) AS 'LASTED' FROM STATEHISTORY 
					INNER JOIN POST
					ON STATEHISTORY.POSTID = POST.ID
					GROUP BY POST.ID
				) AS A
				ON POST.ID = A.ID
				INNER JOIN STATEHISTORY
				ON POST.ID = STATEHISTORY.POSTID
				INNER JOIN TAG
				ON TAG.ID = POST.TAGID
				INNER JOIN USER
				ON USER.ID = POST.AUTHORID
				WHERE STATEHISTORY.AT = A.LASTED AND STATEHISTORY.STATE = 1
				ORDER BY CREATEDAT DESC
				LIMIT 6
		""");
	}
}
