package com.undefined24.ssm.controller;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.undefined24.ssm.service.UserService;
import com.undefined24.ssm.vo.Bill;
import com.undefined24.ssm.vo.Goods;
import com.undefined24.ssm.vo.Receiver;
import com.undefined24.ssm.vo.Train;
import com.undefined24.ssm.vo.User;

@Controller
@SessionAttributes(value={"attr1","attr2"})
public class UserController {

	@Autowired
	UserService userService;
	
	private User current_user;
	private boolean have_user = false;
	private boolean same_name = false;
	private boolean same_number = false;
	
	public boolean isSame_number() {
		return same_number;
	}

	public void setSame_number(boolean same_number) {
		this.same_number = same_number;
	}

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
		return "main";
	}
	
	/*
	 * 前往登录页面homepage.jsp
	 */
	@RequestMapping(value="/gotoHomepage",method=RequestMethod.GET)
	public String gotoHomepage() {
		return "homepage";
	}
	
	/*
	 * 前往接件页面receiver.jsp
	 */
	@RequestMapping(value="/gotoReceiver",method=RequestMethod.GET)
	public ModelAndView gotoReceiver() {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_user()==false) {
			mv.setViewName("login");
		}else {
			mv.setViewName("receiver");
		}
		return mv;
	}
	
	/*
	 * 接件
	 */
	@RequestMapping(value="/receive",method=RequestMethod.POST)
	public ModelAndView receive(@RequestParam("startpoint") String startpoint,
			@RequestParam("trainnumber") String trainnumber,
			@RequestParam("traintime") String traintime,
			@RequestParam("arrivepoint") String arrivepoint,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Train train = new Train();
		train.setStartpoint(startpoint);
		train.setTrainnumber(trainnumber);
		train.setTraintime(traintime);
		train.setArrivepoint(arrivepoint);
		try {
			List<Bill> ablegoodslist = userService.receiveGoods(train);
			if(ablegoodslist!=null) {
				mv.addObject("ablegoodslist", ablegoodslist);
			}
			else {
				req.setAttribute("receive-msg", "没有合适您接件的物品");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("");
		return mv;
	}
			
	/*
	 * 前往寄件页面sender.jsp
	 */
	@RequestMapping(value="/gotoSender",method=RequestMethod.GET)
	public ModelAndView gotoSender() {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_user()==false) {
			mv.setViewName("login");
		}else {
			mv.setViewName("sender");
		}
		return mv;
	}
	
	/*
	 * 寄件
	 */
	@RequestMapping(value="/send",method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("name") String name,
			@RequestParam("type") String type,
			@RequestParam("weight") float weight,
			@RequestParam("receivername") String receivername,
			@RequestParam("receiverphone") String receiverphone,
			@RequestParam("receiveraddress") String receiveraddress,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_user()==false) {
			mv.setViewName("login");
		}else {
			Goods goods = new Goods();
			Bill bill = new Bill();
			Receiver rec = new Receiver();
			goods.setName(name);
			goods.setType(type);
			goods.setWeight(weight);
			bill.setGiveUserID(this.getCurrent_user().getUserID());
			bill.setArriveaddress(receiveraddress);
			bill.setSendaddress(this.getCurrent_user().getUseraddress());
			rec.setName(receivername);
			rec.setPhone(receiverphone);
			rec.setAddress(receiveraddress);
			try {
				if(name==""||type==""||weight==0||receivername==""||receiverphone==""||receiveraddress=="") {
					req.setAttribute("send-msg", "下单失败，请重试");
					mv.setViewName("sender");
					return mv;
				}
				int result_1 = userService.addGoods(goods);
				int result_2 = userService.addBill(bill);
				int result_3 = userService.addReceiver(rec);
				if(result_1==0||result_2==0||result_3==0) {
					req.setAttribute("send-msg", "下单失败，请重试");
				}else {
					req.setAttribute("send-msg","下单成功");
				}
			}catch(Exception e) {
				req.setAttribute("send-msg", "下单失败，请重试");
				e.printStackTrace();
			}
			mv.setViewName("sender");
		}
		return mv;
	}
	
	/*
	 * 前往个人中心user_center.jsp
	 */
	@RequestMapping(value="/gotoUserCenter",method=RequestMethod.GET)
	public ModelAndView gotoUserCenter() {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_user()==false) {
			mv.setViewName("homepage");
		}else {
			List<Bill> sendlist = userService.sendGoods(this.getCurrent_user());
			List<Bill> acceptlist = userService.acceptGoods(this.getCurrent_user());
			mv.addObject("sendlist", sendlist);
			mv.addObject("acceptlist", acceptlist);
			mv.addObject("user",this.getCurrent_user());
			mv.setViewName("user_center");
		}
		return mv;
	}
	
	/*
	 * 用户名查重
	 */
	@RequestMapping(value="/checkuser",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	@ResponseBody
	public String checkUser(@RequestParam("nickname") String nickname) {
		User user = new User();
		this.setSame_name(false);
		System.out.println(nickname);
		String msg = "";
		user.setNickname(nickname);
		User user1 = null;
		user1 = userService.CheckUser(user);
		if(user1!=null) {
			msg= "此用户名已被占用";
			this.setSame_name(true);
		}else {
			msg= "此用户名可用";
		}
		return msg;
	}
	
	/*
	 * 身份证号查重
	 */
	@RequestMapping(value="/checknumber",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	@ResponseBody
	public String checkNumber(@RequestParam("usernumber") String usernumber) {
		User user = new User();
		this.setSame_number(false);
		String msg = "";
		user.setUsernumber(usernumber);
		User user1 = null;
		user1 = userService.checkUserNumber(usernumber);
		if(user1!=null) {
			msg= "此身份证已被使用";
			this.setSame_name(true);
		}else {
			msg= "此身份证可用";
			
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
			@RequestParam("username") String username,
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
			user.setUsername(username);
			user.setUsersex(usersex);
			user.setUserphone(userphone);
			user.setUserpwd(userpwd);
			user.setUsernumber(usernumber);
			user.setUseraddress(useraddress);
			if(nickname==""||username==""||usersex==""||userphone==""||userpwd==""||usernumber==""||useraddress=="") {
				req.setAttribute("register-msg","注册失败");
				mv.setViewName("register");
				return mv;
			}
			if(this.isSame_name()==true) {
				req.setAttribute("register-msg","用户名已被使用，请更改");
				mv.setViewName("register");
			}else if(this.isSame_number()==true){
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
					this.setCurrent_user(user);
					this.setHave_user(true);
					List<Bill> sendlist = userService.sendGoods(this.getCurrent_user());
					List<Bill> acceptlist = userService.acceptGoods(this.getCurrent_user());
					mv.addObject("sendlist", sendlist);
					mv.addObject("acceptlist", acceptlist);
					mv.addObject("user", user);
					mv.setViewName("user_center");
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
			if(this.isHave_user()==false) {
				mv.setViewName("login");
			}else {
				mv.addObject("user",this.getCurrent_user());
				List<Bill> sendlist = userService.sendGoods(this.getCurrent_user());
				List<Bill> acceptlist = userService.acceptGoods(this.getCurrent_user());
				mv.addObject("sendlist", sendlist);
				mv.addObject("acceptlist", acceptlist);
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
			List<Bill> sendlist = userService.sendGoods(this.getCurrent_user());
			List<Bill> acceptlist = userService.acceptGoods(this.getCurrent_user());
			mv.addObject("sendlist", sendlist);
			mv.addObject("acceptlist", acceptlist);
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
			List<Bill> sendlist = userService.sendGoods(this.getCurrent_user());
			List<Bill> acceptlist = userService.acceptGoods(this.getCurrent_user());
			mv.addObject("sendlist", sendlist);
			mv.addObject("acceptlist", acceptlist);
			mv.setViewName("user_center");
		}
		return mv;
	}
	
	/*
	 * 跳转去
	 */
}
