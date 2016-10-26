package com.goldeneyes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goldeneyes.pojo.Role;
import com.goldeneyes.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/showRole")
	public String findAllUser(HttpServletRequest request,Model model){
		Role role = roleService.selectByPrimaryKey(1);
		model.addAttribute("role", role);
		return "showRole";
	}
}
