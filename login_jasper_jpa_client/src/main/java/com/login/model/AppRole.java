package com.login.model;


 

public class AppRole {
    
    private Long roleId;
 
    private String roleName;
 
    public Long getRoleId() {
        return roleId;
    }
 
    public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppRole(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
 
    public String getRoleName() {
        return roleName;
    }
 
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
     
}