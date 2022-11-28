package models.BO;

import java.util.ArrayList;

import models.Bean.Tag;
import models.DAO.TagDAO;

public class TagBO extends BaseBO {
	private TagDAO tagDAO;
	public TagBO() {
		tagDAO = new TagDAO();
	}
	public ArrayList<Tag> getAll() {
		return tagDAO.getAll();
	}
}
