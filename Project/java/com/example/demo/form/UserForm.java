package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class UserForm implements Serializable{

	private int id;

	@NotEmpty
	private String user_id;
	@NotEmpty
	private String password;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}