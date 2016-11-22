package com.aartek.prestigepoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adminlogin")
public class LoginDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADMIN_LOGIN_ID")
	private Integer adminLoginId;
	
	public Integer getAdminLoginId() {
		return adminLoginId;
	}
	public void setAdminLoginId(Integer adminLoginId) {
		this.adminLoginId = adminLoginId;
	}
	@Column(name = "EMAIL_ID")
	private String email_id;
	@Column(name = "PASSWORD")
	private String password;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return ("email_id:"+email_id+ " password:" +password);
		
	}
	

}
