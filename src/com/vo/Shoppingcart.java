package com.vo;

import java.util.Date;

public class Shoppingcart {
	int cart_id;
	String email;
	int product_id;
	int amount;
	
	public Shoppingcart() {
		// TODO Auto-generated constructor stub
	}


	public Shoppingcart(String email, int product_id, int amount) {
		this.email = email;
		this.product_id = product_id;
		this.amount = amount;
	}
	
	

	public Shoppingcart(int cart_id, String email, int product_id, int amount) {
		this.cart_id = cart_id;
		this.email = email;
		this.product_id = product_id;
		this.amount = amount;
	}


	public int getCart_id() {
		return cart_id;
	}


	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Shoppingcart [cart_id=" + cart_id + ", email=" + email + ", product_id=" + product_id + ", amount="
				+ amount + "]";
	}




	
	
}
