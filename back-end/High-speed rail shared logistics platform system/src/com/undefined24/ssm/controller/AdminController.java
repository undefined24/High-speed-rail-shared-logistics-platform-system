package com.undefined24.ssm.controller;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.undefined24.ssm.service.AdminService;
import com.undefined24.ssm.vo.Administrator;
import com.undefined24.ssm.vo.Bill;
import com.undefined24.ssm.vo.Goods;
import com.undefined24.ssm.vo.Receiver;
import com.undefined24.ssm.vo.User;
import com.undefined24.ssm.vo.Worker;

@Controller
@SessionAttributes(value={"admin"})
public class AdminController {

	private int delete_worker_id;
	private int delete_user_id;
	private int delete_trackingID;
	public int page_show = 6;
	
	
	public int getDelete_trackingID() {
		return delete_trackingID;
	}

	public void setDelete_trackingID(int delete_trackingID) {
		this.delete_trackingID = delete_trackingID;
	}

	public int getDelete_worker_id() {
		return delete_worker_id;
	}

	public void setDelete_worker_id(int delete_worker_id) {
		this.delete_worker_id = delete_worker_id;
	}
	public int getDelete_user_id() {
		return delete_user_id;
	}

	public void setDelete_user_id(int delete_user_id) {
		this.delete_user_id = delete_user_id;
	}
	
	@Autowired
	AdminService adminService;
	
	/*
	 * 前往登录页面
	 */
	@RequestMapping(value="/adminlogin",method=RequestMethod.GET)
	public ModelAndView gotoLogin(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		PageHelper.startPage(pn, page_show);
		Administrator admin = (Administrator) session.getAttribute("admin");
		//如果没有登录
		if(admin==null) {
			mv.setViewName("admin_login");
		}else {
			List<Worker> workerlist = adminService.showWorker();
			PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
			mv.addObject("workerlist",page);
			mv.addObject("login_admin",admin);
			mv.setViewName("admin_staff");
		}
		return mv;	
	}
	
	/*
	 * 登录
	 */
	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public ModelAndView Login(@RequestParam(value="pn",defaultValue="1") int pn,
			@RequestParam("adminname") String adminname,
			@RequestParam("adminpwd") String adminpwd,
			HttpServletRequest req,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Administrator admin = new Administrator();
		Administrator login_admin = null;
		admin.setAdminname(adminname);
		admin.setAdminpwd(adminpwd);
		login_admin = adminService.adminLogin(admin);
		if(login_admin==null) {
			req.setAttribute("admin-login-msg", "用户名或密码错误");
			mv.setViewName("admin_login");
		}else {
			session = req.getSession();
			session.setAttribute("admin", login_admin);
			PageHelper.startPage(pn, page_show);
			List<Worker> workerlist = adminService.showWorker();
			PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
			mv.addObject("workerlist", page);
			mv.addObject("login_admin",login_admin);
			mv.setViewName("admin_staff");
		}
		return mv;
	}
	
	/*
	 * 登出
	 */
	@RequestMapping(value="/adminlogout",method=RequestMethod.GET)
	public ModelAndView Logout(SessionStatus status) {
		ModelAndView mv=new ModelAndView();
		status.setComplete();
		mv.setViewName("homepage");
		return mv;
	}
	
	/*
	 * 前往员工管理页面
	 */
	@RequestMapping(value="/adminstaff",method=RequestMethod.GET)
	public ModelAndView gotoAdminStaff(HttpSession session,
			@RequestParam(value="pn",defaultValue="1") int pn,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Administrator admin = (Administrator) session.getAttribute("admin");
		if(admin==null) {
			mv.setViewName("admin_login");
		}else {
			PageHelper.startPage(pn, page_show);
			mv.addObject("login_admin",admin);
			List<Worker> workerlist = adminService.showWorker();
			PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
			mv.addObject("workerlist", page);
			mv.addObject("page","adminstaff");
			mv.setViewName("admin_staff");
		}
		return mv;	
	}
	
	/*
	 * 增加员工
	 */
	@RequestMapping(value="/addworker",method=RequestMethod.POST)
	public ModelAndView addWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			@RequestParam("workername") String workername,
			@RequestParam("workerposition") String workerposition,
			@RequestParam("workersex") String workersex,
			@RequestParam("workersalary") String workersalary,
			@RequestParam("workercheckcard") String workercheckcard,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Worker new_worker = new Worker();
		new_worker.setWorkername(workername);
		new_worker.setWorkerposition(workerposition);
		new_worker.setWorkersex(workersex);
		new_worker.setWorkersalary(workersalary);
		new_worker.setWorkercheckcard(workercheckcard);
		if(adminService.checkWorker(new_worker)!=null) {
			req.setAttribute("addworker-msg","此员工已存在！");
		}else {
			int result = adminService.addWorker(new_worker);
			if(result==0) {
				req.setAttribute("addworker-msg", "员工添加失败，请重试");
			}else {
				req.setAttribute("addworker-msg", "员工添加成功！");
			}
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",admin);
		List<Worker> workerlist = adminService.showWorker();
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist", page);
		mv.addObject("page","adminstaff");
		mv.setViewName("admin_staff");
		return mv;
	}
	
	/*
	 * 员工修改时显示信息
	 */
	@RequestMapping(value="/showEditWorker",method=RequestMethod.POST)
	@ResponseBody
	public Worker showEditWorker(@RequestParam("workerID") String workerID) {
		Worker worker = null;
		try {
			 worker = adminService.showEidtWorker(Integer.parseInt(workerID));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return worker;
	}
	
	/*
	 * 修改员工
	 */
	@RequestMapping(value="/editworker",method=RequestMethod.POST)
	public ModelAndView editWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			@RequestParam("edit_worker_name") String name,
			@RequestParam("edit_worker_position") String position,
			@RequestParam("edit_worker_sex") String sex,
			@RequestParam("edit_worker_salary") String salary,
			@RequestParam("edit_worker_checkcard") String checkcard,
			@RequestParam("hidden_edit_workerID") String hidden_edit_workerID,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Worker edit_worker = new Worker();
		edit_worker.setWorkerID(Integer.parseInt(hidden_edit_workerID));
		edit_worker.setWorkername(name);
		edit_worker.setWorkerposition(position);
		edit_worker.setWorkersex(sex);
		edit_worker.setWorkersalary(salary);
		edit_worker.setWorkercheckcard(checkcard);
		try {
			int result = adminService.editWorker(edit_worker);
			if(result==0) {
				System.out.println(1);
				req.setAttribute("editworker-msg", "修改失败");
			}else {
				req.setAttribute("editworker-msg", "修改成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",admin);
		List<Worker> workerlist = adminService.showWorker();
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist",page);
		mv.addObject("page","adminstaff");
		mv.setViewName("admin_staff");
		return mv;
	}
	
	/*
	 * 去删除员工
	 */
	@RequestMapping(value="/gotodeleteworker",method=RequestMethod.POST)
	@ResponseBody
	public void gotoDeleteWorker(@RequestParam("workerID") String workerID) {
		this.setDelete_worker_id(Integer.parseInt(workerID));
	}
	
	/*
	 * 删除员工
	 */
	@RequestMapping(value="/deleteworker",method=RequestMethod.GET)
	public ModelAndView deleteWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Worker delete_worker = new Worker();
		delete_worker.setWorkerID(this.getDelete_worker_id());
		int result = adminService.deleteWorker(delete_worker);
		if(result==0) {
			req.setAttribute("deleteworker-msg", "删除失败");
		}else { 
			req.setAttribute("deleteworker-msg", "删除成功");
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",admin);
		List<Worker> workerlist = adminService.showWorker();
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist",page);
		mv.addObject("page","adminstaff");
		mv.setViewName("admin_staff");
		return mv;
	}
	
	/*
	 * 搜索员工
	 */
	@RequestMapping(value="/searchWorker")
	public ModelAndView searchWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			@RequestParam("search") String search) {
		ModelAndView mv = new ModelAndView();
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",admin);
		List<Worker> workerlist = new ArrayList<>();
		if(search==""){
			workerlist = adminService.showWorker();
		}else {
			workerlist = adminService.searchWorker(search);
		}
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist",page);
		mv.addObject("search",search);
		mv.addObject("page","searchWorker");
		mv.setViewName("admin_staff");
		return mv;	
	}
	
	/*
	 * 前往寄件管理页面
	 */
	@RequestMapping(value="/admingoods",method=RequestMethod.GET)
	public ModelAndView gotoAdminGoods(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Administrator admin = (Administrator) session.getAttribute("admin");
		if(admin==null) {
			mv.setViewName("admin_login");
		}else {
			PageHelper.startPage(pn, page_show);
			List<Goods> goodslist = adminService.goodsManage();
			PageInfo<Goods> page = new PageInfo<Goods>(goodslist);
			mv.addObject("goodslist",page);
			mv.addObject("page","admingoods");
			mv.addObject("login_admin",admin);
			mv.setViewName("admin_goods");
		}
		return mv;	
	}
	
	/*
	 * 搜索物品
	 */
	@RequestMapping(value="/searchGoods")
	public ModelAndView searchGoods(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			@RequestParam("search") String search) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login_admin",admin);
		List<Goods> goodslist = new ArrayList<>();
		if(search==""){
			goodslist = adminService.goodsManage();
		}else {
			goodslist = adminService.searchGoods(search);
		}
		PageHelper.startPage(pn, page_show);
		PageInfo<Goods> page = new PageInfo<Goods>(goodslist);
		mv.addObject("goodslist",page);
		mv.addObject("search",search);
		mv.addObject("page","searchGoods");
		mv.setViewName("admin_goods");
		return mv;	
	}
	
	/*
	 * 去删除物品
	 */
	@RequestMapping(value="/gotodeletegoods",method=RequestMethod.POST)
	@ResponseBody
	public void gotoDeleteGoods(@RequestParam("trackingID") String trackingID) {
		this.setDelete_trackingID(Integer.parseInt(trackingID));
	}
	
	/*
	 * 删除物品
	 */
	@RequestMapping(value="/deletegoods",method=RequestMethod.GET)
	public ModelAndView deleteGoods(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Goods delete_goods = new Goods();
		Bill delete_bill = new Bill();
		Receiver delete_rec = new Receiver();
		delete_goods.setTrackingID(this.getDelete_trackingID());
		delete_bill.setTrackingID(this.getDelete_trackingID());
		delete_rec.setTrackingID(this.getDelete_trackingID());
		try {
			int result_2 = adminService.deleteBill(delete_bill);
			int result_1 = adminService.deleteGoods(delete_goods);
			int result_3 = adminService.deleteReceiver(delete_rec);
			if(result_3==0||result_1==0||result_2==0) {
				req.setAttribute("deletegoods-msg", "删除失败");
			}else { 
				req.setAttribute("deletegoods-msg", "删除成功");
				System.out.println("删除成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",admin);
		List<Goods> goodslist = adminService.goodsManage();
		PageInfo<Goods> page = new PageInfo<Goods>(goodslist);
		mv.addObject("goodslist",page);
		mv.addObject("page","admingoods");
		mv.setViewName("admin_goods");
		return mv;
	}
	
	/*
	 * 物品修改时显示信息
	 */
	@RequestMapping(value="/showEditGoods",method=RequestMethod.POST)
	@ResponseBody
	public Goods showEditGoods(@RequestParam("trackingID") String trackingID) {
		Goods goods = null;
		try {
			goods = adminService.showEditGoods(Integer.parseInt(trackingID));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
	
	/*
	 * 修改物品
	 */
	@RequestMapping(value="/editgoods",method=RequestMethod.POST)
	public ModelAndView editGoods(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			@RequestParam("name") String name,
			@RequestParam("giveUserID") int giveUserID,
			@RequestParam("acceptUserID") int acceptUserID,
			@RequestParam("type") String type,
			@RequestParam("weight") float weight,
			@RequestParam("trainnumber") String trainnumber,
			@RequestParam("cost") float cost,
			@RequestParam("complete") boolean complete,
			@RequestParam("hidden_edit_trackingID") String hidden_edit_trackingID,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Goods edit_goods = new Goods();
		Bill edit_bill = new Bill();
		edit_goods.setName(name);
		edit_goods.setTrackingID(Integer.parseInt(hidden_edit_trackingID));
		edit_goods.setType(type);
		edit_goods.setWeight(weight);
		edit_bill.setTrackingID(Integer.parseInt(hidden_edit_trackingID));
		edit_bill.setGiveUserID(giveUserID);
		edit_bill.setAcceptUserID(acceptUserID);
		edit_bill.setTrainnumber(trainnumber);
		edit_bill.setCost(cost);
		edit_bill.setComplete(complete);
		if(complete==true) {
			String str[] = new Timestamp(new Date().getTime()).toString().split("\\.");
			String time = str[0];
			edit_bill.setCompletetime(time);
		}else {
			edit_bill.setCompletetime("");
		}
		try {
			int result_1 = adminService.editGoods(edit_goods);
			int result_2 = adminService.editBill(edit_bill);
			if(result_1==0||result_2==0) {
				req.setAttribute("editgoods-msg", "修改失败");
			}else {
				System.out.println("修改成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",admin);
		List<Goods> goodslist = adminService.goodsManage();
		PageInfo<Goods> page = new PageInfo<Goods>(goodslist);
		mv.addObject("goodslist",page);
		mv.addObject("page","admingoods");
		mv.setViewName("admin_goods");
		return mv;
	}
	
	/*
	 * 前往用户管理页面
	 */
	@RequestMapping(value="/adminvip",method=RequestMethod.GET)
	public ModelAndView gotoAdminVip(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Administrator admin = (Administrator) session.getAttribute("admin");
		if(admin==null) {
			mv.setViewName("admin_login");
		}else {
			PageHelper.startPage(pn, page_show);
			List<User> userlist = adminService.showUser();
			PageInfo<User> page = new PageInfo<User>(userlist);
			mv.addObject("userlist",page);
			mv.addObject("login_admin",admin);
			mv.addObject("page", "adminvip");
			mv.setViewName("admin_vip");
		}
		return mv;	
	}
	
	/*
	 * 用户修改时显示信息
	 */
	@RequestMapping(value="/showEditUser",method=RequestMethod.POST)
	@ResponseBody
	public User showEditUser(@RequestParam("userID") String userID) {
		User user = null;
		try {
			user = adminService.showEditUser(Integer.parseInt(userID));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/*
	 * 修改用户
	 */
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	public ModelAndView editUser(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			@RequestParam("nickname") String nickname,
			@RequestParam("usersex") String usersex,
			@RequestParam("usernumber") String usernumber,
			@RequestParam("userphone") String userphone,
			@RequestParam("useraddress") String useraddress,
			@RequestParam("hidden_edit_userID") String hidden_edit_userID,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User edit_user = new User();
		edit_user.setUserID(Integer.parseInt(hidden_edit_userID));
		edit_user.setNickname(nickname);
		edit_user.setUsersex(usersex);
		edit_user.setUsernumber(usernumber);
		edit_user.setUserphone(userphone);
		edit_user.setUseraddress(useraddress);
		try {
			int result = adminService.editUser(edit_user);
			if(result==0||(nickname==""||usersex==""||usernumber==""||userphone==""||useraddress=="")) {
				req.setAttribute("edituser-msg", "修改失败");
			}else {
				req.setAttribute("edituser-msg", "修改成功");
			}
		}catch(Exception e) {
			req.setAttribute("edituser-msg", "修改失败");
			System.out.println("error");
		}
		PageHelper.startPage(pn, page_show);
		List<User> userlist = adminService.showUser();
		PageInfo<User> page = new PageInfo<User>(userlist);
		mv.addObject("userlist",page);
		mv.addObject("login_admin",admin);
		mv.addObject("page", "adminvip");
		mv.setViewName("admin_vip");
		return mv;
	}
	
	/*
	 * 去删除用户
	 */
	@RequestMapping(value="/gotodeleteuser",method=RequestMethod.POST)
	@ResponseBody
	public void gotoDeleteUser(@RequestParam("userID") String userID) {
		this.setDelete_user_id(Integer.parseInt(userID));
	}
	
	/*
	 * 删除用户
	 */
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User delete_user = new User();
		delete_user.setUserID(this.getDelete_user_id());
		int result = adminService.deleteUser(delete_user);
		if(result==0) {
			req.setAttribute("deleteuser-msg", "删除失败");
		}else {
			req.setAttribute("deleteuser-msg", "删除成功");
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",admin);
		List<User> userlist = adminService.showUser();
		PageInfo<User> page = new PageInfo<User>(userlist);
		mv.addObject("userlist",page);
		mv.addObject("page", "adminvip");
		mv.setViewName("admin_vip");
		return mv;
	}
	
	/*
	 * 搜索用户
	 */
	@RequestMapping(value="/searchUser")
	public ModelAndView searchUser(@RequestParam(value="pn",defaultValue="1") int pn,
			@ModelAttribute("admin") Administrator admin,
			@RequestParam("userSearch") String userSearch) {
		ModelAndView mv = new ModelAndView();
		List<User> userlist = new ArrayList<>();
		if(userSearch==""){
			userlist = adminService.showUser();
		}else {
			userlist = adminService.searchUser(userSearch);
		}
		PageHelper.startPage(pn, page_show);
		PageInfo<User> page = new PageInfo<User>(userlist);
		mv.addObject("userlist",page);
		mv.addObject("userSearch",userSearch);
		mv.addObject("login_admin",admin);
		mv.addObject("page", "searchUser");
		mv.setViewName("admin_vip");
		return mv;	
	}
}
