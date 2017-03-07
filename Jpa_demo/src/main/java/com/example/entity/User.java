package com.example.entity;

import java.io.Serializable;

import javax.persistence.*;


//import org.hibernate.jpamodelgen.xml.jaxb.GenerationType;

@Entity
@Table(name ="users")
public class User implements Serializable{

	private static final long serialVersionUD =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;

	@Column(name ="phone")
	private String phone;

	public User(){

	}

	public User(User user) {
		this.userId = user.userId;
		this.userName = user.userName;
		this.email = user.email;
		this.password = user.password;
		this.phone=user.phone;
		}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	} 
	
	public Integer getUserid() {
		return userId;
	}
	
	public void setUserid(Integer userid) {
		this.userId = userid;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
