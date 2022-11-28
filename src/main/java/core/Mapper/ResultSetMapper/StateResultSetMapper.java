package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Bean.State;
import models.Bean.User;
import models.Bean.Common.PostState;

public class StateResultSetMapper implements IResultSetMapper<State>{

	@Override
	public State map(ResultSet row) {
		try {
			if (row == null || row.getRow() == 0) 
				return null;
			State state = new State();
			state.setId(row.getString("ID"));
			int stateName = row.getInt("NAME");
			state.setAt(row.getTimestamp("AT"));
			state.setState((stateName == 0) ? PostState.Pending : (stateName == 1 ? PostState.Publish : PostState.Ban));
			state.setPostID(row.getString("POSTID"));
			return state;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
