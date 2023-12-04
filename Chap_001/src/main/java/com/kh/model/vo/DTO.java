package com.kh.model.vo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	CREATE TABLE Test_User (
	USER_NUMBER NUMBER PRIMARY KEY,
	USER_ID VARCHAR2(50) UNIQUE NOT NULL,
	USER_NAME VARCHAR2(50) NOT NULL,
	USER_AGE NUMBER NOT NULL
	);

 */
public class DTO  {
	private int user_number;
	private String user_id;
	private String user_name;
	private int user_age;
	
	// Getter / Setter
	public int getUser_number() {
		return user_number;
	}
	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
}
