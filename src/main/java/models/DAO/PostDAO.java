package models.DAO;

import java.util.ArrayList;

import core.Mapper.ResultSetMapper.PostResultSetMapper;
import models.Bean.Post;

public class PostDAO extends BaseDAO<Post>{
	public PostDAO() {
		super(new PostResultSetMapper());
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

}
