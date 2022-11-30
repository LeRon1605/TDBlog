package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Bean.StateStatistic;
import models.Bean.Common.PostState;

public class StateStatisticResultSetMapper implements IResultSetMapper<StateStatistic> {

	@Override
	public StateStatistic map(ResultSet row) {
		try {
			if (row == null || row.getRow() == 0) 
				return null;
			StateStatistic stateStatistic = new StateStatistic();
			stateStatistic.setCount(row.getInt("COUNT"));
			stateStatistic.setAt(row.getDate("AT"));
			int state = row.getInt("STATE");
			stateStatistic.setState((state == 0) ? PostState.Pending : (state == 1 ? PostState.Publish : PostState.Ban));
			return stateStatistic;
		} catch (SQLException e) {
			return null;
		}
	}

}
