package com.vo;

public class ImageFile {
	
	String img_name;
	
	public ImageFile() {
		// TODO Auto-generated constructor stub
	}

	public ImageFile(String img_name) {
		this.img_name = img_name;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	@Override
	public String toString() {
		return "ImageFile [img_name=" + img_name + "]";
	}
	
	
	
}
