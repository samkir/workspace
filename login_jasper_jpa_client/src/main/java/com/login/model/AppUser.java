package com.login.model;


public class AppUser {
 
    
    private Long userId;
 
    private String userName;
 
    private String encrytedPassword;
 
    private boolean enabled;
 
    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getEncrytedPassword() {
        return encrytedPassword;
    }
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
 
    public boolean isEnabled() {
        return enabled;
    }
 
    public AppUser(Long userId, String userName, String encrytedPassword, boolean enabled) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
	}

	

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
 
}