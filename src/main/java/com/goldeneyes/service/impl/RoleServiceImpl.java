package com.goldeneyes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goldeneyes.IDao.RoleMapper;
import com.goldeneyes.pojo.Role;
import com.goldeneyes.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Resource
	public RoleMapper roleMapper;

	@Override
	public List<Role> FindAllRole() {
		List<Role> roles = roleMapper.findAllRole();
		return roles;
	}
	
	@Override
	public Role selectByPrimaryKey(Integer id){
		Role role = roleMapper.selectByPrimaryKey(id);
		return role;
	}

}
