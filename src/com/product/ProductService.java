package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Services;
import com.vo.Product;
import com.vo.User;

@Service("productservice")
public class ProductService implements Services<String, Product> {
	@Resource(name="productdao")
	Dao dao;
		
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void register(Product v) {
		dao.insert(v);
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public void modify(Product v) {
		dao.update(v);
	}

	@Override
	public Product get(String k) {
		return (Product) dao.select(k);
	}

	@Override
	public ArrayList<Product> get() {
		return dao.select();
	}

}
