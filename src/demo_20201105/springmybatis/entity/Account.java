package demo_20201105.springmybatis.entity;

import java.io.Serializable;

public class Account implements Serializable {

	private Integer userId;
	
	private String userName;
	
		
	public Account() {
	}

	public Account(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
