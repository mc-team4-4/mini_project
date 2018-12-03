package com.vo;

public class Product {
	int product_id;
	int category_id;
	String name;
	int price;
	int amount;
	String img;
	String content;

	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int category_id, String name, int price, int amount, String img, String content) {
		this.category_id = category_id;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.img = img;
		this.content = content;
	}

	public Product(int product_id, int category_id, String name, int price, int amount, String img, String content) {
		this.product_id = product_id;
		this.category_id = category_id;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.img = img;
		this.content = content;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", category_id=" + category_id + ", name=" + name + ", price="
				+ price + ", amount=" + amount + ", img=" + img + ", content=" + content + "]";
	}
	
	
	


}
