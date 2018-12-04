package com.mapper;

import java.util.ArrayList;

import com.vo.Product;

public interface ProductMapper {
	public void insert(Product obj);
	public void delete(String obj);
	public void update(Product obj);
	public Object select(String obj);
	public ArrayList<Product> selectall();
}



