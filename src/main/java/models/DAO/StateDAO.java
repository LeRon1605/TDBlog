package models.DAO;

import core.Mapper.ResultSetMapper.StateResultSetMapper;
import models.Bean.State;

public class StateDAO extends BaseDAO<State>{
	public StateDAO() {
		super(new StateResultSetMapper());
	}
	
	public boolean add(State state) {
		String query = """
			INSERT INTO STATEHISTORY(ID, STATE, AT, POSTID)
			VALUES(?, ?, ?, ?);
		""";
		return this.executeQuery(query, new Object[] { state.getId(), state.getStateRaw(), state.getAt(), state.getPostID() });
	}
	
	public State getCurrentStateOfPost(String postID) {
		String query = """
			SELECT * FROM STATEHISTORY 
			WHERE POSTID = ?
			ORDER BY AT DESC
			LIMIT 1
		""";
		return this.getRecordSingle(query, new Object[] { postID });
	}
}
