package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.frame.Services;
import com.vo.User;

@Service("userservice")
public class UserService implements Services<String, User> {
	@Resource(name="userdao")
	Dao dao;
		
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void register(User v) {
		dao.insert(v);
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public void modify(User v) {
		dao.update(v);
	}

	@Override
	public User get(String k) {
		return (User) dao.select(k);
	}

	@Override
	public ArrayList<User> get() {
		return dao.select();
	}

}
