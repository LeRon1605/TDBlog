package models.DAO;

import java.util.ArrayList;

import core.Mapper.ResultSetMapper.TagResultSetMapper;
import models.Bean.Tag;

public class TagDAO extends BaseDAO<Tag>{
	public TagDAO() {
		super(new TagResultSetMapper());
	}
	
	public ArrayList<Tag> getAll() {
		return this.getRecordArray("SELECT * FROM TAG");
	}
}
