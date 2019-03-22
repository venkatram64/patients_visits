package com.srijan.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String createdDate;
	private String modifiedDate;
	
	public User() {}
	
	public User(long id, String fristName, String lastName, String emailId, String password) {
		this(fristName, lastName, emailId, password);
		this.id = id;
	}

	public User(String fristName, String lastName, String emailId, String password) {
		this.firstName = fristName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

}
