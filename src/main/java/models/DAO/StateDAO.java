package models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import core.Mapper.ResultSetMapper.IResultSetMapper;
import core.Mapper.ResultSetMapper.StateResultSetMapper;
import core.Mapper.ResultSetMapper.StateStatisticResultSetMapper;
import models.Bean.State;
import models.Bean.StateStatistic;

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
	
	public ArrayList<StateStatistic> countStateInRange(Date start, Date end) {
		String query = """
			SELECT STATEHISTORY.STATE, DATE(STATEHISTORY.AT) AS 'AT', COUNT(STATEHISTORY.POSTID) AS 'COUNT' FROM STATEHISTORY INNER JOIN
			(
				SELECT POST.ID, MAX(STATEHISTORY.AT) AS 'LASTED' FROM STATEHISTORY 
				INNER JOIN POST
				ON STATEHISTORY.POSTID = POST.ID
				GROUP BY POST.ID, DATE(STATEHISTORY.AT)
			) AS A
			ON A.ID = STATEHISTORY.POSTID
			WHERE STATEHISTORY.AT = A.LASTED AND DATE(STATEHISTORY.AT) BETWEEN ? AND ?
			GROUP BY DATE(STATEHISTORY.AT), STATEHISTORY.STATE
			ORDER BY DATE(STATEHISTORY.AT), STATEHISTORY.STATE;
		""";
		Connection connection = getConnection();
		if (connection == null) 
			return null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
			PreparedStatement statement = getPrepareStatement(connection, query, new Object[] { formatter.format(start), formatter.format(end) });
			ResultSet result = statement.executeQuery();
			ArrayList<StateStatistic> data = new ArrayList<StateStatistic>();
			IResultSetMapper<StateStatistic> mapper = new StateStatisticResultSetMapper();
			while (result.next()) {
				data.add(mapper.map(result));
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
