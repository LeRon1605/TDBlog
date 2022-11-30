package models.Bean;

import models.Bean.Common.PostState;
import java.util.Date;

public class StateStatistic {
	private int count;
	private Date at;
	private PostState state;
	
	public StateStatistic() {
		
	}
	
	public StateStatistic(PostState state, int count, Date date) {
		this.state = state;
		this.count = count;
		this.at = date;
	}
	
	public int getCount() {
		return count;
	}
	public Date getAt() {
		return at;
	}
	public PostState getState() {
		return state;
	}
	
	public void setState(PostState state) {
		this.state = state;
	}
	public void setAt(Date at) {
		this.at = at;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
