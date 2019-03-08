package com.undefined24.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.undefined24.ssm.service.UserService;
import com.undefined24.ssm.util.Line;
import com.undefined24.ssm.vo.Bill;
import com.undefined24.ssm.vo.Goods;
import com.undefined24.ssm.vo.Receiver;
import com.undefined24.ssm.vo.Train;
import com.undefined24.ssm.vo.User;

@Controller
@SessionAttributes(value={"current_user"})
public class UserController {

	@Autowired
	UserService userService;
	
	private String trainnumber;
	private int rec_id = 0;
	private int arriveID = 0;
	private boolean same_name = false;
	private boolean same_number = false;
	
	public int getArriveID() {
		return arriveID;
	}

	public void setArriveID(int arriveID) {
		this.arriveID = arriveID;
	}

	public String getTrainnumber() {
		return trainnumber;
	}

	public void setTrainnumber(String trainnumber) {
		this.trainnumber = trainnumber;
	}

	public int getRec_id() {
		return rec_id;
	}

	public void setRec_id(int rec_id) {
		this.rec_id = rec_id;
	}

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

	/*
	 * 前往主页
	 */
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String gotoMain(HttpSession session) {
		return "main";
	}
	
	/*
	 * 前往运费查询
	 */
	@RequestMapping(value="/feight",method=RequestMethod.GET)
	public String gotoFeight(HttpSession session) {
		return "freight_inquiry";
	}
	
	/*
	 * 前往登录页面homepage.jsp
	 */
	@RequestMapping(value="/gotoHomepage",method=RequestMethod.GET)
	public String gotoHomepage(HttpSession session) {
		return "homepage";
	}
	
	/*
	 * 订单查询
	 */
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public ModelAndView search(@RequestParam("search_str") String search_str,
			HttpServletRequest req,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
		if(current_user==null) {
			mv.setViewName("login");
		}else {
			List<Bill> searchBillList = userService.searchBill(search_str);
			if(searchBillList.isEmpty()) {
				req.setAttribute("search-msg", "没有此订单");
				mv.setViewName("main");
				return mv;
			}
			if(searchBillList.get(0).getAcceptUserID()==current_user.getUserID()) {
				req.setAttribute("search-msg", "1");
				mv.setViewName("main");
			}else if(searchBillList.get(0).getGiveUserID()==current_user.getUserID()){
				req.setAttribute("search-msg", "2");
				mv.setViewName("main");
			}else {
				mv.setViewName("main");
				req.setAttribute("search-msg", "抱歉，您没有权限");
			}
		}
		return mv;
	}
	
	/*
	 * 前往接件页面receiver.jsp
	 */
	@RequestMapping(value="/gotoReceiver",method=RequestMethod.GET)
	public ModelAndView gotoReceiver(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
		if(current_user==null) {
			mv.setViewName("login");
		}else {
			mv.setViewName("receiver");
		}
		return mv;
	}
	
	/*
	 * 接件显示
	 */
	@RequestMapping(value="/receive",method=RequestMethod.POST)
	@ResponseBody
	public List<Bill> receive(@RequestParam("startpoint") String startpoint,
			@RequestParam("trainnumber") String trainnumber,
			@RequestParam("traintime") String traintime,
			@RequestParam("arrivepoint") String arrivepoint,
			HttpServletRequest req,
			HttpSession session) {
		User current_user = (User) session.getAttribute("current_user");
		if(startpoint==""||trainnumber==""||traintime==""||arrivepoint=="") {
			return null;
		}
		List<String> poslist = Line.Get(trainnumber);
		System.out.println(poslist);
		System.out.println(startpoint);
		System.out.println(arrivepoint);
		if(poslist.contains(startpoint)==false||poslist.contains(arrivepoint)==false) {
			return null;
		}
		Train train = new Train();
		train.setStartpoint(startpoint);
		train.setTrainnumber(trainnumber);
		this.setTrainnumber(trainnumber);
		train.setTraintime(traintime);
		train.setArrivepoint(arrivepoint);
		List<Bill> ablegoodslist = userService.receiveGoods(train);
		if(ablegoodslist!=null) {
			for(int i=0;i<ablegoodslist.size();i++) {
				Receiver receiver = new Receiver();
				int trackingID = ablegoodslist.get(i).getTrackingID();
				receiver.setTrackingID(trackingID);
				receiver.setAddress(arrivepoint);
				System.out.println(receiver);
				Receiver rec = userService.selectReceiver(receiver);
				ablegoodslist.get(i).setReceiver(rec);
				if(ablegoodslist.get(i).getReceiver()==null||ablegoodslist.get(i).getGiveUserID()==current_user.getUserID()) {
					ablegoodslist.remove(i);
				}
			}
		}
		return ablegoodslist;
	}
	
	/*
	 * 前往确认接件
	 */
	@RequestMapping(value="/recConfirm",method=RequestMethod.GET)
	public void recConfirm(HttpSession session,@RequestParam("id") int id) {
		this.setRec_id(id);
		System.out.println(id);
	}
	
	/*
	 * 确认接件confirm
	 */
	@RequestMapping(value="/confirm",method=RequestMethod.GET)
	public ModelAndView confirm(HttpSession session,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
		System.out.println(current_user);
		Bill bill = new Bill();
		bill.setTrackingID(this.getRec_id());
		bill.setTrainnumber(this.getTrainnumber());
		bill.setTrainnumber(trainnumber);
		bill.setAcceptUserID(current_user.getUserID());
		System.out.println(bill);
		try {
			int result=userService.changeBill(bill);
			if(result==0) {
				req.setAttribute("confirm-msg", "接单失败，请重试");
			}else {
				req.setAttribute("confirm-msg", "接单成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("receiver");
		return mv;
	}
	
	/*
	 * 前往寄件页面sender.jsp
	 */
	@RequestMapping(value="/gotoSender",method=RequestMethod.GET)
	public ModelAndView gotoSender(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
		if(current_user==null) {
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
			@RequestParam("startaddress") String startaddress,
			HttpServletRequest req,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
		if(current_user==null) {
			mv.setViewName("login");
		}else {
			Goods goods = new Goods();
			Bill bill = new Bill();
			Receiver rec = new Receiver();
			goods.setName(name);
			goods.setType(type);
			goods.setWeight(weight);
			bill.setGiveUserID(current_user.getUserID());
			bill.setArriveaddress(receiveraddress);
			bill.setSendaddress(startaddress);
			bill.setCost(5);
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
	public ModelAndView gotoUserCenter(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
		if(current_user==null) {
			mv.setViewName("homepage");
		}else {
			List<Bill> sendlist = userService.sendGoods(current_user);
			List<Bill> acceptlist = userService.acceptGoods(current_user);
			mv.addObject("sendlist", sendlist);
			mv.addObject("acceptlist", acceptlist);
			mv.addObject("user",current_user);
			mv.setViewName("user_center");
		}
		return mv;
	}
	
	/*
	 * 去确认送达
	 */
	@RequestMapping(value="/gotoArriveConfirm",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	@ResponseBody
	public void gotoArriveConfirm(@RequestParam("trackingID") int trackingID) {
		this.setArriveID(trackingID);
	}
	
	/*
	 * 确认送达
	 */
	@RequestMapping(value="/arriveConfirm",method=RequestMethod.GET)
	public ModelAndView confirm1(HttpSession session,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Bill bill = new Bill();
		bill.setTrackingID(this.getArriveID());
		bill.setCompletetime(dateFormat.format(date));
		Receiver rec = new Receiver();
		rec.setTrackingID(this.getArriveID());
		Receiver receiver = userService.selectReceiverX(rec);
		bill.setArriveaddress(receiver.getAddress());
		try {
			int result = userService.arriveConfirm(bill);
			if(result==0) {
				req.setAttribute("confirm-msg","确认失败");
			}else {
				req.setAttribute("confirm-msg","确认成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<Bill> sendlist = userService.sendGoods(current_user);
		List<Bill> acceptlist = userService.acceptGoods(current_user);
		mv.addObject("sendlist", sendlist);
		mv.addObject("acceptlist", acceptlist);
		mv.addObject("user",current_user);
		mv.setViewName("user_center");
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
			this.setSame_name(false);
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
			this.setSame_number(true);
		}else {
			msg= "此身份证可用";
			this.setSame_number(false);
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
			@RequestParam("idphoto") MultipartFile idphoto,
			HttpServletRequest req,
			HttpSession session) throws IllegalStateException, IOException {
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
			
			String uploadPath =req.getServletContext().getRealPath("upload");
			System.out.println(uploadPath);
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			String realFileName = idphoto.getOriginalFilename();
			String[] tmp = realFileName.split("\\.");
			String type =tmp[tmp.length-1];
			String fileName = ""+System.currentTimeMillis()+"."+type;
			String filePath = uploadPath + File.separator + fileName;
			System.out.println("filepath:"+filePath);
			idphoto.transferTo(new File(filePath));
			String displayFileName=req.getContextPath()+File.separator + "upload"+File.separator +fileName;
			System.out.println(displayFileName);
			user.setPicture(displayFileName);
			
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
					session = req.getSession();
					session.setAttribute("current_user", user);
					req.setAttribute("register-msg", "注册成功");
					List<Bill> sendlist = userService.sendGoods(user);
					List<Bill> acceptlist = userService.acceptGoods(user);
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
	public ModelAndView gotoLogin(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
			if(current_user==null) {
				mv.setViewName("login");
			}else {
				
				mv.addObject("user",current_user);
				List<Bill> sendlist = userService.sendGoods(current_user);
				List<Bill> acceptlist = userService.acceptGoods(current_user);
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
			HttpServletRequest req,
			HttpSession session) {
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
			session = req.getSession();
			session.setAttribute("current_user", login_user);
			List<Bill> sendlist = userService.sendGoods(login_user);
			List<Bill> acceptlist = userService.acceptGoods(login_user);
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
	public ModelAndView Logout(SessionStatus status) {
		ModelAndView mv=new ModelAndView("homepage");
		status.setComplete();
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
    		HttpServletRequest req,
    		HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User current_user = (User) session.getAttribute("current_user");
		if(current_user==null) {
			mv.setViewName("homepage");
		}else {
			if(userpwd.equals(re_userpwd)==false) {
				req.setAttribute("profile-msg", "确认密码错误");
			}else {
				User user = new User();
				user.setUserID(current_user.getUserID());
				user.setNickname(nickname);
				user.setUserphone(userphone);
				user.setUserpwd(userpwd);
				user.setUsernumber(usernumber);
				user.setUseraddress(useraddress);
				System.out.println(this.isSame_name());
				if(this.isSame_name()==true) {
					req.setAttribute("profile-msg","用户名已被使用，请更改");
					mv.addObject("user",current_user);
				}else {
					try {
						int result = userService.ChangeProfile(user);
						if(result==0) {
							req.setAttribute("profile-msg", "个人资料修改失败");
						}else {
							session = req.getSession();
							session.setAttribute("current_user", user);
							mv.addObject("user",user);
							req.setAttribute("profile-msg", "修改成功");
							//显示资料
						}
					}catch(Exception e) {
						req.setAttribute("profile-msg", "系统异常请重试");
					}
				}
			}
			List<Bill> sendlist = userService.sendGoods(current_user);
			List<Bill> acceptlist = userService.acceptGoods(current_user);
			mv.addObject("sendlist", sendlist);
			mv.addObject("acceptlist", acceptlist);
			mv.setViewName("user_center");
		}
		return mv;
	}
	
}
