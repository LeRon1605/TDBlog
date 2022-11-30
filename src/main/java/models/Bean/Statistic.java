package models.Bean;

import java.util.Date;

public class Statistic {
	private int count;
	private Object data;
	private Date date;
	
	public int getCount() {
		return count;
	}
	public Object getData() {
		return data;
	}
	public Date getDate() {
		return date;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
