package com.goldeneyes.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.goldeneyes.IDao.UserMapper;
import com.goldeneyes.pojo.User;
import com.goldeneyes.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource UserMapper userMapper;
	
	@Override
	public User validateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.validateUser(user);
	}

}
