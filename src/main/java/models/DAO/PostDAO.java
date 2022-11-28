package models.DAO;

import java.util.ArrayList;

import core.Mapper.ResultSetMapper.PostResultSetMapper;
import models.Bean.Post;

public class PostDAO extends BaseDAO<Post>{
	public PostDAO() {
		super(new PostResultSetMapper());
	}
	
	public ArrayList<Post> getByFilter(String keyword, String sortBy) {
		String query = """
				SELECT POST.*, USER.NAME AS 'AUTHOR', TAG.NAME AS 'TAG' FROM POST INNER JOIN TAG
				ON POST.TAGID = TAG.ID
				INNER JOIN USER
				ON POST.AUTHORID = USER.ID	
		""";
		if (!keyword.isEmpty()) {
			query += " WHERE POST.NAME LIKE '%" + keyword + "%'";
		}
		if (!sortBy.isEmpty()) {
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
	
	public boolean add(Post post) {
		String query = """
				INSERT INTO POST(ID, NAME, CONTENT, VIEW, TIME, CREATEDAT, UPDATEDAT, AUTHORID, TAGID)
				VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);
		""";
		return this.executeQuery(query, new Object[] { post.getID(), post.getName(), post.getContent(), post.getViewCount(), post.getTotalTime(), post.getCreatedAt(), post.getUpdatedAt(), post.getAuthorID(), post.getTagID() });
	}

}
