package com.vo;

public class User {
	String email;
	String password;
	String password_confirm;
	String name;
	String phone_number;
	String status;
	String address;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	public User(String email, String password, String name, String phone_number, String address) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
	}

	public User(String email, String password, String password_confirm, String name, String phone_number,
			String address) {
		this.email = email;
		this.password = password;
		this.password_confirm = password_confirm;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
	}


	public User(String email, String password, String password_confirm, String name, String phone_number, String status,
			String address) {
		this.email = email;
		this.password = password;
		this.password_confirm = password_confirm;
		this.name = name;
		this.phone_number = phone_number;
		this.status = status;
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPassword_confirm() {
		return password_confirm;
	}


	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", password_confirm=" + password_confirm + ", name="
				+ name + ", phone_number=" + phone_number + ", status=" + status + ", address=" + address + "]";
	}
	
	
	
	
	
	
}
