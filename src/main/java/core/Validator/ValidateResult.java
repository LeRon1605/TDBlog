package core.Validator;

public class ValidateResult {
	private boolean status;
	private String[] messages;
	
	public ValidateResult(boolean status) {
		this.status = status;
		this.messages = null;
	}
	
	public ValidateResult(boolean status, String[] messages) {
		this.status = status;
		this.messages = messages;
	}
	
	public boolean isSuccess() {
		return status;
	}
	public boolean isFailure() {
		return !status;
	}
	public String[] getMessages() {
		return messages;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setMessages(String[] messages) {
		this.messages = messages;
	}
}
