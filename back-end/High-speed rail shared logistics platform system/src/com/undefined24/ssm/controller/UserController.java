package com.undefined24.ssm.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.undefined24.ssm.service.UserService;
import com.undefined24.ssm.vo.User;

@Controller
@SessionAttributes(value={"attr1","attr2"})
public class UserController {

	@Autowired
	UserService userService;
	
	/*
	 * 前往注册页面
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String gotoRegister() {
		return "register";
	}
	
	/*
	 * 注册提交
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView Register(@RequestParam("nickname") String nickname,
			@RequestParam("usersex") String usersex,
			@RequestParam("userphone") String userphone,
			@RequestParam("userpwd") String userpwd,
			@RequestParam("usernumber") String usernumber,
			@RequestParam("useraddress") String useraddress,
			HttpServletRequest req) {
		//获取用户输入
		User user = new User();
		ModelAndView mv = new ModelAndView();
		//判断昵称是否合法
		String pattern = "^[\\\\u4e00-\\\\u9fa5a-zA-Z][\\\\u4e00-\\\\u9fa5a-zA-Z]+$";
		boolean isLegal = Pattern.matches(pattern, nickname);
		if(isLegal) {
			user.setNickname(nickname);
			user.setUsersex(usersex);
			user.setUserphone(userphone);
			user.setUserpwd(userpwd);
			user.setUsernumber(usernumber);
			user.setUseraddress(useraddress);
			if(userService.CheckUser(user)!=null) {
				req.setAttribute("register-msg","用户名已被使用，请更改");
				mv.setViewName("register");
			}else {
				int result = userService.Register(user);
				if(result==0) {
					req.setAttribute("register-msg", "注册失败，请重试");
					mv.setViewName("register");
				}else {
					req.setAttribute("register-msg", "注册成功");
					mv.setViewName("register");
					mv.addObject("attr1", user.getNickname());
					mv.addObject("attr2", user.getUserpwd());
				 }
			}
		}else {
			req.setAttribute("register-msg", "用户名非法，请更改");
			mv.setViewName("register");
		}
		return mv;
	}
	
	/*
	 * 前往登录页面
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView gotoLogin() {
		ModelAndView mv = new ModelAndView();
		//如果没有登录
//		if(attr1==null) {
//			mv.setViewName("login");
//		}else {
			mv.setViewName("login");//修改
//		}
		return mv;	
	}
	
	/*
	 * 登录
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView Login(@RequestParam("nickname") String nickname,
			@RequestParam("userpwd") String userpwd,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		user.setNickname(nickname);
		user.setUserpwd(userpwd);
		User login_user = new User();
		login_user = userService.Login(user);
		if(login_user==null) {
			req.setAttribute("login-msg", "用户名或密码错误");
			mv.setViewName("login");
		}else {
			mv.addObject("attr1",login_user.getNickname());
			mv.addObject("attr2", login_user.getUserpwd());
			mv.setViewName("profile");
		}
		return mv;
	}
	
	/*
	 * 用户登出
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView Logout(SessionStatus status) {
		ModelAndView mv=new ModelAndView("login");
		status.setComplete();
		return mv;
	}
	
	/*
	 * 修改密码
	 */
	@RequestMapping(value="/changepwd",method=RequestMethod.POST)
	public ModelAndView changePwd(@RequestParam("oldpassword") String oldpassword,
			@RequestParam("newpassword") String newpassword,
			@RequestParam("confirmpassword") String confirmpassword,
			@ModelAttribute("attr1")String nickname, 
			@ModelAttribute("attr2")String userpwd,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		//如果输入密码错误
		if(oldpassword.equals(userpwd)==false) {
			req.setAttribute("check-pwd-msg","输入密码错误，请重试");
		}
		else if(newpassword.equals(confirmpassword)==false) {
			req.setAttribute("check-pwd-msg","两次输入不一致，请重试");
		}else {
			User user = new User();
			User current_user = null;
			user.setNickname(nickname);
			current_user = userService.CheckUser(user);
			current_user.setUserpwd(newpassword);
			int result = userService.ChangePwd(current_user);
			//数据库插入失败
			if(result==0) {
				req.setAttribute("check-pwd-msg", "更改密码失败，请重试");
			}else {
				mv.addObject("attr2",current_user.getUserpwd());
				mv.setViewName("profile");
			}
		}
		return mv;
	}
	
	/*
	 * 更改个人简介
	 */
	@RequestMapping(value="/changeprofile",method=RequestMethod.POST)
	public ModelAndView changeProfile(@RequestParam("useraddress") String useraddress,
			@RequestParam("usersex") String usersex,
			@RequestParam("userbirthday") String userbirthday,
			@RequestParam("note") String note,
			@ModelAttribute("attr1")String attr1, 
    		@ModelAttribute("attr2")String attr2,
    		HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		User current_user = null;
		user.setNickname(attr1);
		current_user = userService.CheckUser(user);
		if(current_user==null) {
			mv.setViewName("profile");
		}else {
			current_user.setUseraddress(useraddress);
			current_user.setUsersex(usersex);
			current_user.setNote(note);
			try {
				int result = userService.ChangeProfile(current_user);
				//修改失败
				if(result==0) {
					req.setAttribute("profile-msg", "个人资料修改失败");
				}else {
					//显示资料
				}
			}catch(Exception e) {
				req.setAttribute("profile-msg", "系统异常请重试");
			}
		}
		mv.setViewName("profile");
		return mv;
	}
	
	/*
	 * 跳转去个人资料页面
	 */
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public ModelAndView gotoProfile(@ModelAttribute("attr1")String attr1, 
			@ModelAttribute("attr2")String attr2,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		User current_user = null;
		user.setNickname(attr1);
		current_user = userService.CheckUser(user);
		if(current_user==null) {
			mv.setViewName("login");
		}else {
			mv.setViewName("profile");
			//设置个人信息显示
		}
		return mv;
	}
	
	/*
	 * 跳转去
	 */
}
