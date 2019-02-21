package com.undefined24.ssm.controller;


import java.util.ArrayList;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.undefined24.ssm.service.AdminService;
import com.undefined24.ssm.vo.Administrator;
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
	private boolean have_admin=false;
	public int page_show = 6;
	
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
	 * 鍓嶅線鍛樺伐绠＄悊椤甸潰
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
			mv.setViewName("admin_staff");
		}
		return mv;	
	}
	/*
	 * 鍓嶅線鐧诲綍椤甸潰
	 */
	@RequestMapping(value="/adminlogin",method=RequestMethod.GET)
	public ModelAndView gotoLogin(@RequestParam(value="pn",defaultValue="1") int pn) {
		ModelAndView mv = new ModelAndView();
		PageHelper.startPage(pn, page_show);
		//濡傛灉娌℃湁鐧诲綍
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
	 * 鐧诲綍
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
			req.setAttribute("admin-login-msg", "鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒");
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
	 * 鐢ㄦ埛鐧诲嚭
	 */
	@RequestMapping(value="/adminlogout",method=RequestMethod.GET)
	public ModelAndView Logout(SessionStatus status) {
		ModelAndView mv=new ModelAndView("adminlogin");
		status.setComplete();
		return mv;
	}
	
	/*
	 * 淇敼瀵嗙爜
	 */
	@RequestMapping(value="/adminchangepwd",method=RequestMethod.POST)
	public ModelAndView changePwd(@RequestParam("oldpassword") String oldpassword,
			@RequestParam("newpassword") String newpassword,
			@RequestParam("confirmpassword") String confirmpassword,
			@ModelAttribute("attr1")String attr1, 
			@ModelAttribute("attr2")String attr2,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		//濡傛灉杈撳叆瀵嗙爜閿欒
		if(oldpassword.equals(attr2)==false) {
			req.setAttribute("admin-check-pwd-msg","杈撳叆瀵嗙爜閿欒锛岃閲嶈瘯");
		}
		else if(newpassword.equals(confirmpassword)==false) {
			req.setAttribute("admin-check-pwd-msg","涓ゆ杈撳叆涓嶄竴鑷达紝璇烽噸璇�");
		}else {
			Administrator admin = new Administrator();
			Administrator current_admin = null;
			admin.setAdminname(attr1);
			admin.setAdminpwd(attr2);
			current_admin = adminService.adminLogin(admin);
			current_admin.setAdminpwd(newpassword);
			int result = adminService.adminChangePwd(current_admin);
			//鏁版嵁搴撴彃鍏ュけ璐�
			if(result==0) {
				req.setAttribute("admin-check-pwd-msg", "鏇存敼瀵嗙爜澶辫触锛岃閲嶈瘯");
			}else {
				mv.addObject("attr2",current_admin.getAdminpwd());
				mv.setViewName("adminprofile");
			}
		}
		return mv;
	}
	
	/*
	 * 澧炲姞鍛樺伐
	 */
	@RequestMapping(value="/addworker",method=RequestMethod.POST)
	public ModelAndView addWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			@RequestParam("workername") String workername,
			@RequestParam("workerposition") String workerposition,
			@RequestParam("workersex") String workersex,
			@RequestParam("workersalary") int workersalary,
			@RequestParam("workercheckcard") int workercheckcard,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Worker new_worker = new Worker();
		new_worker.setWorkername(workername);
		new_worker.setWorkerposition(workerposition);
		new_worker.setWorkersex(workersex);
		new_worker.setWorkersalary(workersalary);
		new_worker.setWorkercheckcard(workercheckcard);
		if(adminService.checkWorker(new_worker)!=null) {
			req.setAttribute("addworker-msg","姝ゅ憳宸ュ凡瀛樺湪锛�");
		}else {
			int result = adminService.addWorker(new_worker);
			if(result==0) {
				req.setAttribute("addworker-msg", "鍛樺伐娣诲姞澶辫触锛岃閲嶈瘯");
			}else {
				req.setAttribute("addworker-msg", "鍛樺伐娣诲姞鎴愬姛锛�");
			}
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Worker> workerlist = adminService.showWorker();
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist", page);
		mv.setViewName("admin_staff");
		return mv;
	}
	
	/*
	 * 鎵撳紑淇敼鍛樺伐鐣岄潰
	 */
	@RequestMapping(value="/editworker",method=RequestMethod.GET)
	public void gotoEditWorker(@RequestParam(value="edit_workerID") int edit_workerID) {
		System.out.println(this.getEdit_worker_id());
		this.setEdit_worker_id(edit_workerID);
	}
	
	/*
	 * 淇敼鍛樺伐
	 */
	@RequestMapping(value="/editworker",method=RequestMethod.POST)
	public ModelAndView editWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			@RequestParam("edit_worker_name") String name,
			@RequestParam("edit_worker_position") String position,
			@RequestParam("edit_worker_sex") String sex,
			@RequestParam("edit_worker_salary") int salary,
			@RequestParam("edit_worker_checkcard") int checkcard,
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
		
		if(adminService.checkWorker(edit_worker)!=null) {
			req.setAttribute("editworker-msg","姝ゅ憳宸ュ凡瀛樺湪锛�");
		}else {
			try {
				int result = adminService.editWorker(edit_worker);
				if(result==0) {
					System.out.println(1);
					req.setAttribute("editworker-msg", "淇敼澶辫触");
				}else {
					req.setAttribute("editworker-msg", "淇敼鎴愬姛");
				}
			}catch(Exception e) {
				System.out.println("error");
			}
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Worker> workerlist = adminService.showWorker();
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist",page);
		mv.setViewName("admin_staff");
		return mv;
	}
	/*
	 * 鎵撳紑鍒犻櫎鐢ㄦ埛鐣岄潰
	 */
	@RequestMapping(value="/gotoDeleteWorker",method=RequestMethod.GET)
	public void gotoDeleteWorker(@RequestParam("delete_workerID") int delete_workerID) {
		this.setDelete_worker_id(delete_workerID);
	}
	/*
	 * 鍒犻櫎鍛樺伐
	 */
	@RequestMapping(value="/deleteworker",method=RequestMethod.GET)
	public ModelAndView deleteWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Worker delete_worker = new Worker();
		delete_worker.setWorkerID(this.getDelete_worker_id());
		int result = adminService.deleteWorker(delete_worker);
		if(result==0) {
			req.setAttribute("deleteworker-msg", "鍒犻櫎澶辫触");
		}else { 
			req.setAttribute("deleteworker-msg", "鍒犻櫎鎴愬姛");
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
		List<Worker> workerlist = adminService.showWorker();
		PageInfo<Worker> page = new PageInfo<Worker>(workerlist);
		mv.addObject("workerlist",page);
		mv.setViewName("admin_staff");
		return mv;
	}
	
	/*
	 * 鎼滅储鍛樺伐
	 */
	@RequestMapping(value="/searchWorker")
	public ModelAndView searchWorker(@RequestParam(value="pn",defaultValue="1") int pn,
			@RequestParam("search") String search) {
		ModelAndView mv = new ModelAndView();
		System.out.println(1);
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
		mv.setViewName("admin_staff");
		return mv;	
	}
	
	/*
	 * 鍓嶅線瀵勪欢绠＄悊椤甸潰
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
	 * 鍓嶅線鐢ㄦ埛绠＄悊椤甸潰
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
			mv.setViewName("admin_vip");
		}
		return mv;	
	}
	
	/*
	 * 鎵撳紑淇敼鐢ㄦ埛鐣岄潰
	 */
	@RequestMapping(value="/gotoEditUser",method=RequestMethod.GET)
	public void gotoEditUser(@RequestParam("edit_userID") int edit_userID) {
		this.setEdit_user_id(edit_userID);
	}
	/*
	 * 淇敼鐢ㄦ埛
	 */
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	public ModelAndView editWorker(@RequestParam(value="pn",defaultValue="1") int pn,
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
		
		if(adminService.checkUser(edit_user)!=null) {
			req.setAttribute("edituser-msg","姝ゅ憳宸ュ凡瀛樺湪锛�");
		}else {
			try {
				int result = adminService.editUser(edit_user);
				if(result==0) {
					req.setAttribute("edituser-msg", "淇敼澶辫触");
				}else {
					req.setAttribute("edituser-msg", "淇敼鎴愬姛");
				}
			}catch(Exception e) {
				req.setAttribute("edituser-msg", "淇敼澶辫触");
				System.out.println("error");
			}
		}
		PageHelper.startPage(pn, page_show);
		List<User> userlist = adminService.showUser();
		PageInfo<User> page = new PageInfo<User>(userlist);
		mv.addObject("userlist",page);
		mv.addObject("login_admin",this.getCurrent_admin());
		mv.setViewName("admin_vip");
		return mv;
	}
	
	/*
	 * 鎵撳紑鍒犻櫎鐢ㄦ埛鐣岄潰
	 */
	@RequestMapping(value="/gotoDeleteUser",method=RequestMethod.GET)
	public void gotoDeleteUser(@RequestParam("delete_userID") int delete_userID) {
		this.setDelete_user_id(delete_userID);
	}
	/*
	 * 鍒犻櫎鐢ㄦ埛
	 */
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam(value="pn",defaultValue="1") int pn,
			HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		User delete_user = new User();
		delete_user.setUserID(this.getDelete_user_id());
		int result = adminService.deleteUser(delete_user);
		if(result==0) {
			req.setAttribute("deleteuser-msg", "鍒犻櫎澶辫触");
		}else { 
			req.setAttribute("deleteuser-msg", "鍒犻櫎鎴愬姛");
		}
		PageHelper.startPage(pn, page_show);
		mv.addObject("login_admin",this.getCurrent_admin());
		List<User> userlist = adminService.showUser();
		PageInfo<User> page = new PageInfo<User>(userlist);
		mv.addObject("userlist",page);
		mv.setViewName("admin_vip");
		return mv;
	}
	
	/*
	 * 鎼滅储鐢ㄦ埛
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
		mv.setViewName("admin_vip");
		return mv;	
	}
}
