package com.mapper;

import java.util.ArrayList;
import com.vo.Shoppingcart;

public interface ShoppingcartMapper {
	public void insert(Shoppingcart obj);
	public void delete(String obj);
	public void update(Shoppingcart obj);
	public Object select(String obj);
	public ArrayList<Shoppingcart> selectall();
	public ArrayList<Shoppingcart> selectlist(String obj);
}



