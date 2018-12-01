package com.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.UserMapper;
import com.vo.User;
@Repository("userdao")
public class UserDao implements Dao<String, User> {

	@Autowired
	UserMapper um;
	
	@Override
	public void insert(User v) {
		um.insert(v);
	}

	@Override
	public void delete(String k) {
		um.delete(k);		
	}

	@Override
	public void update(User v) {
		um.update(v);
	}

	@Override
	public User select(String k) {
		return (User) um.select(k);
	}

	@Override
	public ArrayList<User> select() {
		return um.selectall();
	}

	

}
