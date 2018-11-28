package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Product;
@Service("pbiz")
public class ProductBiz implements Biz<Integer, Product> {
	@Resource(name="pdao")
	Dao dao;
	
	@Override
	public void register(Product v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);		
	}

	@Override
	public void modify(Product v) throws Exception {
		dao.update(v);			
	}

	@Override
	public Product get(Integer k) throws Exception {
		return (Product) dao.select(k);
	}

	@Override
	public ArrayList<Product> get() throws Exception {
		return dao.select();
	}


}







