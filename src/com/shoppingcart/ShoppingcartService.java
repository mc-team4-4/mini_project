package com.shoppingcart;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Services;
import com.vo.Shoppingcart;


@Service("shoppingcartservice")
public class ShoppingcartService implements Services<String, Shoppingcart> {
	@Resource(name="shoppingcartdao")
	Dao dao;
		
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void register(Shoppingcart v) {
		dao.insert(v);
		
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public void modify(Shoppingcart v) {
		dao.update(v);
	}

	@Override
	public Shoppingcart get(String k) {
		return (Shoppingcart) dao.select(k);
	}

	@Override
	public ArrayList<Shoppingcart> get() {
		return dao.select();
	}

	@Override
	public ArrayList<Shoppingcart> get_list(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.select_list(k);
	}

}
