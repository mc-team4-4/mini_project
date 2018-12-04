package com.mapper;

import java.util.ArrayList;

import com.vo.Category;


public interface CategoryMapper {
	public void insert(Category obj);
	public void delete(String obj);
	public void update(Category obj);
	public Object select(String obj);
	public ArrayList<Category> selectall();
}



