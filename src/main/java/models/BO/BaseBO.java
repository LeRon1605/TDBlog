package models.BO;

import java.util.Date;

public abstract class BaseBO {
	public String generateID() {
		return Long.toString(new Date().getTime());
	}
}
