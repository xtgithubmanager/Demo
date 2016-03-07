package com.xt.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.bean.User;
import com.xt.bean.XtParmas;
import com.xt.service.user.IUserService;

@Controller
@RequestMapping("/admin/user")
public class UserManerControl {
	
	@Autowired
	private IUserService userService;


	//管理用户
	@RequestMapping("/list")
	public String managerUser(XtParmas parmas,Model model){	
		List<User> users = userService.findAllUser(parmas);
		int count = userService.countUser(parmas);
		if(users.size()>0){
			model.addAttribute("users",users);
			model.addAttribute("count",count);
			return "user/list";
		}else{
			
			return "";
		}
		
	}
	
	/**
	 * 
	 * (查询用户 通过对应的模版进行渲染)
	 * com.xt.web.user 
	 * 方法名：template
	 * 创建人：肖腾
	 * 时间：2016年1月13日-上午9:24:42 
	 * @param parmas
	 * @param model
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/template")
	public String template(XtParmas parmas,Model model){
		parmas.setIsdelete(0);
		List<User> users = userService.findAllUser(parmas);
		int count = userService.countUser(parmas);
		if(users.size()>0){
			model.addAttribute("users",users);
			model.addAttribute("count",count);
			return "user/template";
		}else{
			return "error";
		}
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(User user){
		userService.update(user);		
		return "success";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(XtParmas parmas){
		userService.delete(parmas);		
		return "success";
	}
}