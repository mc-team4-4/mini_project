package com.category;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Services;
import com.vo.Category;



@Service("categoryservice")
public class CategoryService implements Services<String, Category> {
	@Resource(name="categorydao")
	Dao dao;
		
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void register(Category v) {
		dao.insert(v);
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public void modify(Category v) {
		dao.update(v);
	}

	@Override
	public Category get(String k) {
		return (Category) dao.select(k);
	}

	@Override
	public ArrayList<Category> get() {
		return dao.select();
	}

}
