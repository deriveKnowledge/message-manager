package cn.wannengde.manager.bean;

import java.io.Serializable;

public class Account implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer accountId;

    private Integer userId;

    private String accountName;

    private String accountUser;

    private String accountPassword;
    
    

    @Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", accountName=" + accountName
				+ ", accountUser=" + accountUser + ", accountPassword=" + accountPassword + "]";
	}

	public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser == null ? null : accountUser.trim();
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword == null ? null : accountPassword.trim();
    }
}