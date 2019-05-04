package cn.wannengde.manager.bean;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userPower;

    public Integer getUserId() {
        return userId;
    }

    
    
    public User() {
		super();
	}



	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPower = 1;
	}



	public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userPower="
				+ userPower + "]";
	}
    
	public String toCookie() {
		return userId + "_" + userName + "_" + userPassword;
	}
    
}