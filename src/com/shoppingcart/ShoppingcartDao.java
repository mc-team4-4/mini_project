package com.shoppingcart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.ShoppingcartMapper;
import com.vo.Shoppingcart;

@Repository("shoppingcartdao")
public class ShoppingcartDao implements Dao<String, Shoppingcart> {

	@Autowired
	ShoppingcartMapper scm;
	
	@Override
	public void insert(Shoppingcart v) {

		scm.insert(v);
		
	}

	@Override
	public void delete(String k) {
		scm.delete(k);		
	}

	@Override
	public void update(Shoppingcart v) {
		scm.update(v);
	}

	@Override
	public Shoppingcart select(String k) {
		return (Shoppingcart) scm.select(k);
	}

	@Override
	public ArrayList<Shoppingcart> select() {
		
		return scm.selectall();
	}

	@Override
	public ArrayList<Shoppingcart> select_list(String k) {
		// TODO Auto-generated method stub
		return scm.selectlist(k);
	}

	

}
