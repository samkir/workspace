package com.login.model;


public class UserRole {
 
    public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(Long id, AppUser appUser, AppRole appRole) {
		super();
		this.id = id;
		this.appUser = appUser;
		this.appRole = appRole;
	}


    private Long id;
 
 
    private AppUser appUser;
 
  
    private AppRole appRole;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public AppUser getAppUser() {
        return appUser;
    }
 
    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
 
    public AppRole getAppRole() {
        return appRole;
    }
 
    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
     
}