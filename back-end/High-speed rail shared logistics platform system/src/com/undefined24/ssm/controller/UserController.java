package com.undefined24.ssm.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	private User current_user;
	private boolean have_user = false;
	private boolean same_name = false;
	
	public boolean isSame_name() {
		return same_name;
	}

	public void setSame_name(boolean same_name) {
		this.same_name = same_name;
	}

	public User getCurrent_user() {
		return current_user;
	}

	public void setCurrent_user(User current_user) {
		this.current_user = current_user;
	}

	public boolean isHave_user() {
		return have_user;
	}

	public void setHave_user(boolean have_user) {
		this.have_user = have_user;
	}

	/*
	 * 前往主页
	 */
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String gotoMain() {
		return "../main";
	}
	
	/*
	 * 前往登录页面homepage.jsp
	 */
	@RequestMapping(value="/gotoHomepage",method=RequestMethod.GET)
	public String gotoHomepage() {
		return "homepage";
	}
	
	/*
	 * 前往个人中心user_center.jsp
	 */
	@RequestMapping(value="/gotoUserCenter",method=RequestMethod.GET)
	public String gotoUserCenter() {
		if(this.isHave_user()==false) {
			return "homepage";
		}else {
			return "homepage";
		}
	}
	
	/*
	 * 用户名查重
	 */
	@RequestMapping(value="/checkuser",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	@ResponseBody
	public String checkUser(@RequestParam("nickname") String nickname) {
		User user = new User();
		this.setSame_name(false);
		String msg = "";
		user.setNickname(nickname);
		User user1 = null;
		user1 = userService.CheckUser(user);
		if(user1!=null) {
			msg= "此用户名已被占用";
			this.setSame_name(true);
		}
		return msg;
	}
	
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
			if(this.isSame_name()==true) {
				req.setAttribute("register-msg","用户名已被使用，请更改");
				mv.setViewName("register");
			}else if(userService.checkUserNumber(usernumber)!=null){
				req.setAttribute("register-msg","身份证号已被使用，请更改");
				mv.setViewName("register");
			}
			else {
				int result = userService.Register(user);
				if(result==0) {
					req.setAttribute("register-msg", "注册失败，请重试");
					mv.setViewName("register");
				}else {
					req.setAttribute("register-msg", "注册成功");
					mv.setViewName("register");
				 }
			}
		}else {
			req.setAttribute("register-msg", "用户名非法，请更改");
			mv.setViewName("user_center");
		}
		return mv;
	}
	
	/*
	 * 前往登录页面
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView gotoLogin() {
		ModelAndView mv = new ModelAndView();
			if(this.isHave_user()==false) {
				mv.setViewName("login");
			}else {
				mv.setViewName("user_center");
			}
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
			this.setCurrent_user(login_user);
			this.setHave_user(true);
			mv.addObject("user",login_user);
			mv.setViewName("user_center");
		}
		return mv;
	}
	
	/*
	 * 用户登出
	 */
	@RequestMapping(value="/userLogout",method=RequestMethod.GET)
	public ModelAndView Logout() {
		ModelAndView mv=new ModelAndView("homepage");
		this.setHave_user(false);
		this.setCurrent_user(null);
		return mv;
	}
	
	/*
	 * 更改个人简介
	 */
	@RequestMapping(value="/changeprofile",method=RequestMethod.POST)
	public ModelAndView changeProfile(@RequestParam("nickname") String nickname,
			@RequestParam("userphone") String userphone,
			@RequestParam("userpwd") String userpwd,
			@RequestParam("re_userpwd") String re_userpwd,
			@RequestParam("usernumber") String usernumber,
			@RequestParam("useraddress") String useraddress,
    		HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_user()==false) {
			mv.setViewName("homepage");
		}else {
			if(userpwd.equals(re_userpwd)==false) {
				req.setAttribute("profile-msg", "确认密码错误");
			}else {
				User user = new User();
				user.setUserID(this.getCurrent_user().getUserID());
				user.setNickname(nickname);
				user.setUserphone(userphone);
				user.setUserpwd(userpwd);
				user.setUsernumber(usernumber);
				user.setUseraddress(useraddress);
				try {
					int result = userService.ChangeProfile(user);
					if(result==0) {
						req.setAttribute("profile-msg", "个人资料修改失败");
					}else {
						this.setCurrent_user(user);
						mv.addObject("user",user);
						req.setAttribute("profile-success-msg", "修改成功");
						//显示资料
					}
				}catch(Exception e) {
					req.setAttribute("profile-msg", "系统异常请重试");
				}
			}
			mv.setViewName("user_center");
		}
		return mv;
	}
	
	/*
	 * 跳转去个人资料页面
	 */
	@RequestMapping(value="/user_center",method=RequestMethod.GET)
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
