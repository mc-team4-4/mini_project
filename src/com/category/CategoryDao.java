package com.category;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.*;

import com.vo.Category;


@Repository("categorydao")
public class CategoryDao implements Dao<String, Category> {

	@Autowired
	CategoryMapper ctm;
	
	@Override
	public void insert(Category v) {
		ctm.insert(v);
	}

	@Override
	public void delete(String k) {
		ctm.delete(k);		
	}

	@Override
	public void update(Category v) {
		ctm.update(v);
	}

	@Override
	public Category select(String k) {
		return (Category) ctm.select(k);
	}

	@Override
	public ArrayList<Category> select() {
		return ctm.selectall();
	}

	

}
