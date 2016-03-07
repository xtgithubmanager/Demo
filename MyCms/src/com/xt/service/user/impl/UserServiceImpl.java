package com.xt.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.bean.User;
import com.xt.bean.XtParmas;
import com.xt.dao.user.IUserMapper;
import com.xt.service.user.IUserService;

@Service
public class UserServiceImpl  implements IUserService{
    
	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public User findUser(XtParmas parmas) {
		User user =   userMapper.findUser(parmas);
		return user;
	}

	@Override
	public List<User> findAllUser(XtParmas parmas) {
		// TODO Auto-generated method stub
		return userMapper.findAllUser(parmas);
	}

	@Override
	public int countUser(XtParmas parmas) {
		// TODO Auto-generated method stub
		return userMapper.countUser(parmas);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public int delete(XtParmas parmas) {
		// TODO Auto-generated method stub
		return userMapper.delete(parmas);
	}

}
