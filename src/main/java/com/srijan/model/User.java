package com.srijan.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private long id;
	private String fristName;
	private String lastName;
	private String emailId;
	private String password;
	private String createdDate;
	private String modifiedDate;
	private int createdBy;
	private int roleId;
	
	public User() {}
	
	
	public User(long id, String fristName, String lastName, String emailId, String password,int roleId) {
		
		this.id = id;
		this.fristName = fristName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.roleId = roleId;
	}

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	

}
