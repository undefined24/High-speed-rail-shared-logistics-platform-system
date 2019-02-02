package com.undefined24.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.undefined24.ssm.service.UserService;
import com.undefined24.ssm.vo.User;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	/*
	 * 注册提交
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView Register(@RequestParam("username") String username,
			@RequestParam("userphone") String userphone,
			@RequestParam("usernumber") String usernumber,
			@RequestParam("usersex") String usersex,
			HttpServletRequest req) {
		//获取用户输入
		User user=new User();
		ModelAndView mv=new ModelAndView();
		user.setUsername(username);
		user.setUserphone(userphone);
		user.setUsernumber(usernumber);
		user.setUsersex(usersex);
		int result=userService.Register(user);
		if(result==0) {
			//注册失败
		}
		else {
			}
		return mv;
	}
}
