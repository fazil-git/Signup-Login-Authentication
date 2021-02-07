package userLogin;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String password;
	private int status;
	public User(int userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	
	public User() {
	}


	public final int getUserId() {
		return userId;
	}
	public final void setUserId(int userId) {
		this.userId = userId;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final int getStatus() {
		return status;
	}
	public final void setStatus(int status) {
		this.status = status;
	}
}
