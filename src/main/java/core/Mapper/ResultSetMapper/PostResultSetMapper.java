package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Bean.Post;

public class PostResultSetMapper implements IResultSetMapper<Post>{

	@Override
	public Post map(ResultSet row) {
		Post post = new Post();
		try {
			if (row == null || row.getRow() == 0) 
				return null;
			post.setID(row.getString("ID"));
			post.setName(row.getString("NAME"));
			post.setImage(row.getString("IMAGE"));
			post.setContent(row.getString("CONTENT"));
			post.setTotalTime(row.getInt("TIME"));
			post.setViewCount(row.getInt("VIEW"));
			post.setCreatedAt(row.getTimestamp("CREATEDAT"));
			post.setUpdatedAt(row.getTimestamp("UPDATEDAT"));
			post.setAuthorID(row.getString("AUTHORID"));
			post.setTagID(row.getString("TAGID"));
		} catch (SQLException e) {
			return null;
		}
		try {
			post.setAuthor(row.getString("AUTHOR"));
		} catch (SQLException e) {
			post.setAuthor(null);
		}
		try {
			post.setAuthorAvatar(row.getString("AVATAR"));
		} catch (SQLException e) {
			post.setAuthorAvatar(null);
		}
		try {
			post.setTag(row.getString("TAG"));
		}catch (SQLException e) {
			post.setTag(null);
		}
		return post;
	}

}
