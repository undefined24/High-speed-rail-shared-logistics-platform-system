package com.undefined24.ssm.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.undefined24.ssm.service.AdminService;
import com.undefined24.ssm.vo.Administrator;
import com.undefined24.ssm.vo.Worker;

@Controller
@SessionAttributes(value={"adminname","adminpwd"})
public class AdminController {

	private int edit_worker_id;
	private Administrator current_admin;
	private boolean have_admin=false;
	
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
	public ModelAndView gotoLogin(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		//如果没有登录
		if(this.isHave_admin()==false) {
			mv.setViewName("admin_login");
		}else {
			List<Worker> workerlist = adminService.showWorker();
			mv.addObject("workerlist",workerlist);
			mv.addObject("login_admin",this.getCurrent_admin());
			mv.setViewName("admin_staff");
		}
		return mv;	
	}
	
	/*
	 * 登录
	 */
	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public ModelAndView Login(@RequestParam("adminname") String adminname,
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
			List<Worker> workerlist = adminService.showWorker();
			mv.addObject("workerlist",workerlist);
			mv.addObject("attr1",login_admin.getAdminname());
			mv.addObject("attr2", login_admin.getAdminpwd());
			mv.addObject("login_admin",login_admin);
			mv.setViewName("admin_staff");
		}
		return mv;
	}
	
	/*
	 * 用户登出
	 */
	@RequestMapping(value="/adminlogout",method=RequestMethod.GET)
	public ModelAndView Logout(SessionStatus status) {
		ModelAndView mv=new ModelAndView("adminlogin");
		status.setComplete();
		return mv;
	}
	
	/*
	 * 修改密码
	 */
	@RequestMapping(value="/adminchangepwd",method=RequestMethod.POST)
	public ModelAndView changePwd(@RequestParam("oldpassword") String oldpassword,
			@RequestParam("newpassword") String newpassword,
			@RequestParam("confirmpassword") String confirmpassword,
			@ModelAttribute("attr1")String attr1, 
			@ModelAttribute("attr2")String attr2,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		//如果输入密码错误
		if(oldpassword.equals(attr2)==false) {
			req.setAttribute("admin-check-pwd-msg","输入密码错误，请重试");
		}
		else if(newpassword.equals(confirmpassword)==false) {
			req.setAttribute("admin-check-pwd-msg","两次输入不一致，请重试");
		}else {
			Administrator admin = new Administrator();
			Administrator current_admin = null;
			admin.setAdminname(attr1);
			admin.setAdminpwd(attr2);
			current_admin = adminService.adminLogin(admin);
			current_admin.setAdminpwd(newpassword);
			int result = adminService.adminChangePwd(current_admin);
			//数据库插入失败
			if(result==0) {
				req.setAttribute("admin-check-pwd-msg", "更改密码失败，请重试");
			}else {
				mv.addObject("attr2",current_admin.getAdminpwd());
				mv.setViewName("adminprofile");
			}
		}
		return mv;
	}
	
	/*
	 * 前往员工管理页面
	 */
	@RequestMapping(value="/adminstaff",method=RequestMethod.GET)
	public ModelAndView gotoAdminStaff(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_admin()==false) {
			mv.setViewName("admin_login");
		}else {
			mv.addObject("login_admin",this.getCurrent_admin());
			List<Worker> workerlist = adminService.showWorker();
			mv.addObject("workerlist",workerlist);
			mv.setViewName("admin_staff");
		}
		return mv;	
	}
	
	/*
	 * 前往寄件管理页面
	 */
	@RequestMapping(value="/admingoods",method=RequestMethod.GET)
	public ModelAndView gotoAdminGoods(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_admin()==false) {
			mv.setViewName("admin_login");
		}else {
			mv.addObject("login_admin",this.getCurrent_admin());
			mv.setViewName("admin_goods");
		}
		return mv;	
	}
	
	/*
	 * 前往用户管理页面
	 */
	@RequestMapping(value="/adminvip",method=RequestMethod.GET)
	public ModelAndView gotoAdminVip(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		if(this.isHave_admin()==false) {
			mv.setViewName("admin_login");
		}else {
			mv.addObject("login_admin",this.getCurrent_admin());
			mv.setViewName("admin_vip");
		}
		return mv;	
	}
	
	/*
	 * 增加员工
	 */
	@RequestMapping(value="/addworker",method=RequestMethod.POST)
	public ModelAndView addWorker(@RequestParam("workername") String workername,
			@RequestParam("workerposition") String workerposition,
			@RequestParam("workersex") String workersex,
			@RequestParam("workersalary") int workersalary,
			@RequestParam("workercheckcard") int workercheckcard,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		System.out.println(1);
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
				mv.addObject("login_admin",this.getCurrent_admin());
				List<Worker> workerlist = adminService.showWorker();
				mv.addObject("workerlist",workerlist);
				mv.setViewName("admin_staff");
			}
		}
		return mv;
	}
	
	/*
	 * 打开修改员工界面
	 */
	@RequestMapping(value="/editworker",method=RequestMethod.GET)
	public ModelAndView gotoEditWorker(@RequestParam(value="edit_workerID") int edit_workerID) {
		ModelAndView mv = new ModelAndView();
		System.out.println(this.getEdit_worker_id());
		this.setEdit_worker_id(edit_workerID);
		return mv;
	}
	
	/*
	 * 修改员工
	 */
	@RequestMapping(value="/editworker",method=RequestMethod.POST)
	public ModelAndView editWorker(@RequestParam("edit_worker_name") String name,
			@RequestParam("edit_worker_position") String position,
			@RequestParam("edit_worker_sex") String sex,
			@RequestParam("edit_worker_salary") int salary,
			@RequestParam("edit_worker_checkcard") int checkcard) {
		ModelAndView mv = new ModelAndView();
		System.out.println(this.getEdit_worker_id());
		
		Worker edit_worker = new Worker();
		edit_worker.setWorkerID(this.getEdit_worker_id());
		edit_worker.setWorkername(name);
		edit_worker.setWorkerposition(position);
		edit_worker.setWorkersex(sex);
		edit_worker.setWorkersalary(salary);
		edit_worker.setWorkercheckcard(checkcard);
		
		int result = adminService.editWorker(edit_worker);
		if(result==0) {
			System.out.print("修改失败");
		}else {
			System.out.println("修改成功");
		}
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Worker> workerlist = adminService.showWorker();
		mv.addObject("workerlist",workerlist);
		mv.setViewName("admin_staff");
		return mv;
	}
	
	/*
	 * 删除员工
	 */
	@RequestMapping(value="/deleteworker",method=RequestMethod.GET)
	public ModelAndView deleteWorker() {
		ModelAndView mv = new ModelAndView();
		Worker delete_worker = new Worker();
		delete_worker.setWorkerID(this.getEdit_worker_id());
		System.out.println(this.getEdit_worker_id());
		int result = adminService.deleteWorker(delete_worker);
		if(result==0) {
			System.out.println("删除失败");
		}else { 
			System.out.println("删除成功");
		}
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Worker> workerlist = adminService.showWorker();
		mv.addObject("workerlist",workerlist);
		mv.setViewName("admin_staff");
		return mv;
	}
}
