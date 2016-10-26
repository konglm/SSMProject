package com.goldeneyes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goldeneyes.pojo.Role;
import com.goldeneyes.pojo.User;
import com.goldeneyes.service.RoleService;
import com.goldeneyes.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,Model model){

		User user = new User();
		user.setAccount(request.getParameter("useraccount"));
		user.setPassword(request.getParameter("userpassword"));

		if(userService.validateUser(user) != null){
			Role role = roleService.selectByPrimaryKey(1);
			model.addAttribute("role", role);
		}
		return "showRole";
	}
}
