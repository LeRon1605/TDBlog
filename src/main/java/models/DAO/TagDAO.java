package models.DAO;

import core.Mapper.ResultSetMapper.TagResultSetMapper;
import models.Bean.Tag;

public class TagDAO extends BaseDAO<Tag>{
	public TagDAO() {
		super(new TagResultSetMapper());
	}
}
