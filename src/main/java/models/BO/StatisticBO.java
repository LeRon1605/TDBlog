package models.BO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import models.Bean.StateStatistic;
import models.Bean.Statistic;
import models.Bean.Common.PostState;
import models.DAO.StateDAO;
import models.DAO.UserDAO;

public class StatisticBO {
	private UserDAO userDAO;
	private StateDAO stateDAO;
	public StatisticBO() {
		userDAO = new UserDAO();
		stateDAO = new StateDAO();
	}
	
	public ArrayList<Statistic> getNewUserInRange(Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		ArrayList<Statistic> data = new ArrayList<Statistic>();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		for (Date date = start.getTime(); start.before(end) || formatter.format(date).equals(formatter.format(end.getTime())); start.add(Calendar.DATE, 1), date = start.getTime()) {
			Statistic statistic = new Statistic();
		    statistic.setCount(userDAO.getNewUserInDay(date).size());
		    statistic.setDate(date);
		    data.add(statistic);
		}
		return data;
	}
	
	public ArrayList<StateStatistic> getStateInRange(Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		ArrayList<StateStatistic> data = new ArrayList<StateStatistic>();
		ArrayList<StateStatistic> statistic = stateDAO.countStateInRange(startDate, endDate);
		int current = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		for (Date date = start.getTime(); start.before(end) || formatter.format(date).equals(formatter.format(end.getTime())); start.add(Calendar.DATE, 1), date = start.getTime()) {
			date.setHours(12);
			date.setMinutes(0);
			date.setSeconds(0);
			if (current < statistic.size()) {
				if (statistic == null || statistic.size() == 0 || date.before(statistic.get(current).getAt())) {
					statistic.add(current, new StateStatistic(PostState.Ban, 0, date));
					statistic.add(current, new StateStatistic(PostState.Publish, 0, date));
					statistic.add(current, new StateStatistic(PostState.Pending, 0, date));
					current += 3;
				}else if (formatter.format(date).equals(formatter.format(statistic.get(current).getAt()))) {
					if (statistic.get(current).getState() != PostState.Pending) {
						statistic.add(current, new StateStatistic(PostState.Pending, 0, date));
					}
					current += 1;
					if (current >= statistic.size() || date.before(statistic.get(current).getAt()) || statistic.get(current).getState() != PostState.Publish) {
						statistic.add(current, new StateStatistic(PostState.Publish, 0, date));
					}
					current += 1;
					if (current >= statistic.size() || date.before(statistic.get(current).getAt()) || statistic.get(current).getState() != PostState.Ban) {
						statistic.add(current, new StateStatistic(PostState.Ban, 0, date));
					}
					current += 1;
				}
			}else {
				statistic.add(new StateStatistic(PostState.Pending, 0, date));
				statistic.add(new StateStatistic(PostState.Publish, 0, date));
				statistic.add(new StateStatistic(PostState.Ban, 0, date));
			}
		}
		return statistic;
	}
}
