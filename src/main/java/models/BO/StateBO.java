package models.BO;

import models.Bean.State;
import models.DAO.StateDAO;

public class StateBO extends BaseBO{
	private StateDAO stateDAO;
	public StateBO() {
		stateDAO = new StateDAO();
	}
	public State getCurrentStateOfPost(String postId) {
		return stateDAO.getCurrentStateOfPost(postId);
	}
}
