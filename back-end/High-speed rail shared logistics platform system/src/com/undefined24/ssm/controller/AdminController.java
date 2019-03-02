package com.undefined24.ssm.controller;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
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
@SessionAttributes(value={"adminname","adminpwd"})
public class AdminController {

	private int edit_worker_id;
	private int delete_worker_id;
	private int edit_user_id;
	private int delete_user_id;
	private Administrator current_admin;
	private int delete_trackingID;
	private int edit_trackdingID;
	private boolean have_admin=false;
	public int page_show = 6;
	
	
	public int getDelete_trackingID() {
		return delete_trackingID;
	}

	public void setDelete_trackingID(int delete_trackingID) {
		this.delete_trackingID = delete_trackingID;
	}

	public int getEdit_trackdingID() {
		return edit_trackdingID;
	}

	public void setEdit_trackdingID(int edit_trackdingID) {
		this.edit_trackdingID = edit_trackdingID;
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
	public int getEdit_user_id() {
		return edit_user_id;
	}

	public void setEdit_user_id(int edit_user_id) {
		this.edit_user_id = edit_user_id;
	}
	public boolean isHave_admin() {
		return have_admin;
	}

	public void setHave_admin(boolean have_admin) {
		this.have_admin = have_admin;
	}

	public Administrator getCurrent_admin() {
		return current_admin;
	}

	public void setCurrent_admin(Administrator current_admin) {
		this.current_admin = current_admin;
	}
	public int getEdit_worker_id() {
		return edit_worker_id;
	}

	public void setEdit_worker_id(int edit_worker_id) {
		this.edit_worker_id = edit_worker_id;
	}
	
	@Autowired
	AdminService adminService;
	
	/*
	 * 前往登录页面
	 */
	@RequestMapping(value="/adminlogin",method=RequestMethod.GET)
	public ModelAndView gotoLogin(@RequestParam(value="pn",defaultValue="1") int pn) {
		ModelAndView mv = new ModelAndView();
		PageHelper.startPage(pn, page_show);
		//如果没有登录
		if(this.isHave_admin()==false) {
			mv.setViewName("admin_login");
		}else {
			List<Worker> workerlist = adminService.showWorker();
			PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
			mv.addObject("workerlist",page);
			mv.addObject("login_admin",this.getCurrent_admin());
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
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Administrator admin = new Administrator();
		Administrator login_admin = null;
		admin.setAdminname(adminname);
		admin.setAdminpwd(adminpwd);
		login_admin = adminService.adminLogin(admin);
		if(login_admin==null) {
			req.setAttribute("admin-login-msg", "用户名或密码错误");
			this.setHave_admin(false);
			this.setCurrent_admin(null);
			mv.setViewName("admin_login");
		}else {
			this.setHave_admin(true);
			this.setCurrent_admin(login_admin);
			PageHelper.startPage(pn, page_show);
			List<Worker> workerlist = adminService.showWorker();
			PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
			mv.addObject("workerlist", page);
			mv.addObject("attr1",login_admin.getAdminname());
			mv.addObject("attr2", login_admin.getAdminpwd());
			mv.addObject("login_admin",login_admin);
			mv.setViewName("admin_staff");
		}
		return mv;
	}
	
	/*
	 * 登出
	 */
	@RequestMapping(value="/adminlogout",method=RequestMethod.GET)
	public ModelAndView Logout() {
		ModelAndView mv=new ModelAndView();
		this.setHave_admin(false);
		this.setCurrent_admin(null);
		mv.setViewName("homepage");
		return mv;
	}
	
	/*
	 * 前往员工管理页面
	 */
	@RequestMapping(value="/adminstaff",method=RequestMethod.GET)
	public ModelAndView gotoAdminStaff(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_admin()==false) {
			mv.setViewName("admin_login");
		}else {
			PageHelper.startPage(pn, page_show);
			mv.addObject("login_admin",this.getCurrent_admin());
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
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Worker> workerlist = adminService.showWorker();
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist", page);
		mv.addObject("page","adminstaff");
		mv.setViewName("admin_staff");
		return mv;
	}
	
	/*
	 * 打开修改员工界面
	 */
	@RequestMapping(value="/editworker",method=RequestMethod.GET)
	public ModelAndView gotoEditWorker(@RequestParam(value="edit_workerID") int edit_workerID) {
		System.out.println(this.getEdit_worker_id());
		ModelAndView mv = new ModelAndView();
		try {
		mv.addObject("edit_worker", adminService.showEidtWorker(edit_workerID));
		}catch(Exception e){
			e.printStackTrace();
		}
		this.setEdit_worker_id(edit_workerID);
		return mv;
	}
	
	/*
	 * 修改员工
	 */
	@RequestMapping(value="/editworker",method=RequestMethod.POST)
	public ModelAndView editWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			@RequestParam("edit_worker_name") String name,
			@RequestParam("edit_worker_position") String position,
			@RequestParam("edit_worker_sex") String sex,
			@RequestParam("edit_worker_salary") String salary,
			@RequestParam("edit_worker_checkcard") String checkcard,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		System.out.println(this.getEdit_worker_id());
		
		Worker edit_worker = new Worker();
		edit_worker.setWorkerID(this.getEdit_worker_id());
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
				//req.setAttribute("editworker-msg", "修改成功");
				System.out.println("修改成功");
			}
		}catch(Exception e) {
			System.out.println("error");
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Worker> workerlist = adminService.showWorker();
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist",page);
		mv.addObject("page","adminstaff");
		mv.setViewName("admin_staff");
		return mv;
	}
	
	/*
	 * 打开删除用户界面
	 */
	@RequestMapping(value="/gotoDeleteWorker",method=RequestMethod.GET)
	public void gotoDeleteWorker(@RequestParam("delete_workerID") int delete_workerID) {
		this.setDelete_worker_id(delete_workerID);
	}
	
	/*
	 * 删除员工
	 */
	@RequestMapping(value="/deleteworker",method=RequestMethod.GET)
	public ModelAndView deleteWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Worker delete_worker = new Worker();
		delete_worker.setWorkerID(this.getDelete_worker_id());
		int result = adminService.deleteWorker(delete_worker);
		if(result==0) {
			req.setAttribute("deleteworker-msg", "删除失败");
		}else { 
			//req.setAttribute("deleteworker-msg", "删除成功");
			System.out.println("删除成功");
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
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
			@RequestParam("search") String search) {
		ModelAndView mv = new ModelAndView();
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
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
	public ModelAndView gotoAdminGoods(@RequestParam(value="pn",defaultValue="1") int pn) {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_admin()==false) {
			mv.setViewName("admin_login");
		}else {
			PageHelper.startPage(pn, page_show);
			List<Goods> goodslist = adminService.goodsManage();
			PageInfo<Goods> page = new PageInfo<Goods>(goodslist);
			mv.addObject("goodslist",page);
			mv.addObject("login_admin",this.getCurrent_admin());
			mv.setViewName("admin_goods");
		}
		return mv;	
	}
	
	/*
	 * 搜索物品
	 */
	@RequestMapping(value="/searchGoods")
	public ModelAndView searchGoods(@RequestParam(value="pn",defaultValue="1") int pn,
			@RequestParam("search") String search) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login_admin",this.getCurrent_admin());
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
	 * 打开删除物品界面
	 */
	@RequestMapping(value="/gotoDeleteGoods",method=RequestMethod.GET)
	public void gotoDeleteGoods(@RequestParam("delete_trackingID") int delete_trackingID) {
		this.setDelete_trackingID(delete_trackingID);
	}
	
	/*
	 * 删除物品
	 */
	@RequestMapping(value="/deletegoods",method=RequestMethod.GET)
	public ModelAndView deleteGoods(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Goods delete_goods = new Goods();
		Bill delete_bill = new Bill();
		Receiver delete_rec = new Receiver();
		delete_goods.setTrackingID(this.getDelete_trackingID());
		delete_bill.setTrackingID(this.getDelete_trackingID());
		delete_rec.setTrackingID(this.getDelete_trackingID());
		try {
			int result_1 = adminService.deleteGoods(delete_goods);
			int result_2 = adminService.deleteBill(delete_bill);
			int result_3 = adminService.deleteReceiver(delete_rec);
			if(result_1==0||result_2==0||result_3==0) {
				req.setAttribute("deletegoods-msg", "删除失败");
			}else { 
				//req.setAttribute("deletegoods-msg", "删除成功");
				System.out.println("删除成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Goods> goodslist = adminService.goodsManage();
		PageInfo<Goods> page = new PageInfo<Goods>(goodslist);
		mv.addObject("goodslist",page);
		mv.addObject("page","admin_goods");
		mv.setViewName("admin_goods");
		return mv;
	}
	
	/*
	 * test
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	@ResponseBody
	public Goods edit(@RequestParam(value="edit_trackingID") int edit_trackingID) {
		Goods edit_goods = adminService.showEditGoods(edit_trackingID);
		return edit_goods;
	}
	
	/*
	 * 打开修改物品
	 */
	@RequestMapping(value="/gotoEditGoods",method=RequestMethod.GET)
	public ModelAndView gotoEditGoods(@RequestParam(value="edit_trackingID") int edit_trackingID) {
		ModelAndView mv = new ModelAndView();
		System.out.println(edit_trackingID);
		try {
			mv.addObject("edit_goods", adminService.showEditGoods(edit_trackingID));
			System.out.println(adminService.showEditGoods(edit_trackingID));
		}catch(Exception e){
			e.printStackTrace();
		}
		this.setEdit_trackdingID(edit_trackingID);
		return mv;
	}
	
	/*
	 * 修改物品
	 */
	@RequestMapping(value="/editgoods",method=RequestMethod.POST)
	public ModelAndView editGoods(@RequestParam(value="pn",defaultValue="1") int pn,
			@RequestParam("name") String name,
			@RequestParam("giveUserID") int giveUserID,
			@RequestParam("acceptUserID") int acceptUserID,
			@RequestParam("type") String type,
			@RequestParam("weight") float weight,
			@RequestParam("trainnumber") String trainnumber,
			@RequestParam("cost") float cost,
			@RequestParam("complete") boolean complete,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Goods edit_goods = new Goods();
		Bill edit_bill = new Bill();
		edit_goods.setName(name);
		edit_goods.setTrackingID(this.getEdit_trackdingID());
		edit_goods.setType(type);
		edit_goods.setWeight(weight);
		edit_bill.setTrackingID(this.getEdit_trackdingID());
		edit_bill.setGiveUserID(giveUserID);
		edit_bill.setAcceptUserID(acceptUserID);
		edit_bill.setTrainnumber(trainnumber);
		edit_bill.setCost(cost);
		edit_bill.setComplete(complete);
		if(complete==true) {
			System.out.println(new Timestamp(new Date().getTime()).toString());
			edit_bill.setCompletetime(new Timestamp(new Date().getTime()).toString());
		}
		System.out.println(complete);
		try {
			int result_1 = adminService.editGoods(edit_goods);
			int result_2 = adminService.editBill(edit_bill);
			if(result_1==0||result_2==0) {
				req.setAttribute("editgoods-msg", "修改失败");
			}else {
				//req.setAttribute("editgoods-msg", "修改成功");
				System.out.println("修改成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Goods> goodslist = adminService.goodsManage();
		PageInfo<Goods> page = new PageInfo<Goods>(goodslist);
		mv.addObject("goodslist",page);
		mv.addObject("page","admin_goods");
		mv.setViewName("admin_goods");
		return mv;
	}
	
	/*
	 * 前往用户管理页面
	 */
	@RequestMapping(value="/adminvip",method=RequestMethod.GET)
	public ModelAndView gotoAdminVip(@RequestParam(value="pn",defaultValue="1") int pn) {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_admin()==false) {
			mv.setViewName("admin_login");
		}else {
			PageHelper.startPage(pn, page_show);
			List<User> userlist = adminService.showUser();
			PageInfo<User> page = new PageInfo<User>(userlist);
			mv.addObject("userlist",page);
			mv.addObject("login_admin",this.getCurrent_admin());
			mv.addObject("page", "adminvip");
			mv.setViewName("admin_vip");
		}
		return mv;	
	}
	
	/*
	 * 打开修改用户界面
	 */
	@RequestMapping(value="/gotoEditUser",method=RequestMethod.GET)
	public ModelAndView gotoEditUser(@RequestParam("edit_userID") int edit_userID) {
		ModelAndView mv = new ModelAndView();
		try{
			mv.addObject("edit_user", adminService.showEditUser(edit_userID));
		}catch(Exception e){
			e.printStackTrace();
		}
		this.setEdit_user_id(edit_userID);
		return mv;
	}
	/*
	 * 修改用户
	 */
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	public ModelAndView editUser(@RequestParam(value="pn",defaultValue="1") int pn,
			@RequestParam("nickname") String nickname,
			@RequestParam("usersex") String usersex,
			@RequestParam("usernumber") String usernumber,
			@RequestParam("userphone") String userphone,
			@RequestParam("useraddress") String useraddress,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		User edit_user = new User();
		edit_user.setUserID(this.getEdit_user_id());
		edit_user.setNickname(nickname);
		edit_user.setUsersex(usersex);
		edit_user.setUsernumber(usernumber);
		edit_user.setUserphone(userphone);
		edit_user.setUseraddress(useraddress);
		System.out.println(edit_user);
		
		try {
			int result = adminService.editUser(edit_user);
			if(result==0||(nickname==""||usersex==""||usernumber==""||userphone==""||useraddress=="")) {
				req.setAttribute("edituser-msg", "修改失败");
			}else {
				//req.setAttribute("edituser-msg", "修改成功");
				System.out.println("修改成功");
			}
		}catch(Exception e) {
			req.setAttribute("edituser-msg", "修改失败");
			System.out.println("error");
		}
		PageHelper.startPage(pn, page_show);
		List<User> userlist = adminService.showUser();
		PageInfo<User> page = new PageInfo<User>(userlist);
		mv.addObject("userlist",page);
		mv.addObject("login_admin",this.getCurrent_admin());
		mv.addObject("page", "adminvip");
		mv.setViewName("admin_vip");
		return mv;
	}
	
	/*
	 * 打开删除用户界面
	 */
	@RequestMapping(value="/gotoDeleteUser",method=RequestMethod.GET)
	public void gotoDeleteUser(@RequestParam("delete_userID") int delete_userID) {
		this.setDelete_user_id(delete_userID);
	}
	/*
	 * 删除用户
	 */
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User delete_user = new User();
		delete_user.setUserID(this.getDelete_user_id());
		int result = adminService.deleteUser(delete_user);
		if(result==0) {
			req.setAttribute("deleteuser-msg", "删除失败");
		}else {
			//req.setAttribute("deleteuser-msg", "删除成功");
			System.out.println("删除成功");
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
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
		mv.addObject("login_admin",this.getCurrent_admin());
		mv.addObject("page", "searchUser");
		mv.setViewName("admin_vip");
		return mv;	
	}
}
