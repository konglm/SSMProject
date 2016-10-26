package com.goldeneyes.service;

import java.util.List;

import com.goldeneyes.pojo.Role;

public interface RoleService {
	List<Role> FindAllRole();

	Role selectByPrimaryKey(Integer id);
}
