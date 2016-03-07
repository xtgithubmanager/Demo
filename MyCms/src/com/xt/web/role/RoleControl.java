package com.xt.web.role;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.bean.Role;
import com.xt.bean.XtParmas;
import com.xt.core.BaseController;
import com.xt.service.role.IRoleService;
import com.xt.service.user.IUserService;
import com.xt.util.TmStringUtils;

/**
 * 后台角色管理
 * RoleControl
 * 创建人:肖腾
 * 时间：2016-01-19 14-37-40
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/admin/role")
public class RoleControl extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping("/list")
	public String list(Model model, XtParmas parmas) {
		parmas.setIsdelete(0);
		List<Role> cons = this.roleService.findRole(parmas);
		if (cons.size() > 0) {
			model.addAttribute("roles", cons);
			return "role/list";
		} else {
			return "error";
		}
	}
	
	
	@RequestMapping("/template")
	public String template(Model model, XtParmas parmas) {
		parmas.setIsdelete(0);
		List<Role> cons = this.roleService.findRole(parmas);
		if (cons.size() > 0) {
			model.addAttribute("roles", cons);
			return "role/template";
		} else {
			return "error";
		}
	}
	
	
	/**
	 * 
	 * (更新角色的相关状态的信息)
	 * com.xt.web.role 
	 * 方法名：update
	 * 创建人：肖腾
	 * 时间：2016年1月19日-下午4:32:49 
	 * @param role
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(Role role){
		roleService.update(role);
		return "success";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(XtParmas parmas){
		roleService.delete(parmas);
		return "success";
	}
	
	//跳转到给用户分配权限的页面
	@RequestMapping(value="/user/{rid}")
	public ModelAndView user(@PathVariable("rid")Integer roleid,XtParmas parmas) {
		parmas.setIsdelete(0);
		parmas.setRoleid(roleid);
		List<HashMap<String, Object>> users = roleService.findRoleUser(parmas);
		int totalCount = roleService.findRoleUserCount(parmas);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", users);
		modelAndView.addObject("count", totalCount);
		modelAndView.setViewName("role/user");
		return modelAndView;
	}
	
	
	/**
	 * 
	 * (给用户分配角色)
	 * com.xt.web.role 
	 * 方法名：saveUserRole
	 * 创建人：肖腾
	 * 时间：2016年1月20日-下午4:56:32 
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/saveUserRole")
	@ResponseBody
	public String saveUserRole(HttpServletRequest request) {
		String rid = request.getParameter("rid");
		String userstring = request.getParameter("userstr");
		// 保存信息
		if (TmStringUtils.isNotEmpty(userstring)) {
			String[] uids = userstring.split(",");
			for (String string : uids) {
				roleService.saveUserRole(Integer.parseInt(string),
						Integer.parseInt(rid));
			}

			return "success";
		} else {
			return "error";
		}
	}
	
	
	
	@RequestMapping("/permission")
	public String permission(){
		return "/role/permission";
	}
	/**
	 * 
	 * (分配权限)
	 * com.xt.web.role 
	 * 方法名：permission
	 * 创建人：肖腾
	 * 时间：2016年1月20日-下午6:21:45 
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/saveRolePermission")
	@ResponseBody
	public String saveRolePermission(HttpServletRequest request){
		String roleid =  request.getParameter("roleid");
		String permissions =  request.getParameter("permissions");
	    //保存信息
		if(TmStringUtils.isNotEmpty(permissions)){
			//重新授权时，先删除中间表该角色的所有权限
			roleService.deleteRolePermission(Integer.parseInt(roleid));
			String [] uids = permissions.split(",");
			for (String string : uids) {
				roleService.saveRolePermission(Integer.parseInt(roleid),Integer.parseInt(string));
			}
			return "success";
		}else{
			return "error";
		}
	}
	
	@RequestMapping("/findPermissionIds")
	@ResponseBody
	public List<HashMap<String, Object>> findPermissionIds(HttpServletRequest request){
		String roleid =  request.getParameter("roleid");
	 	List<HashMap<String, Object>> maps =  roleService.findPermissionByRole(Integer.parseInt(roleid));
		return maps;
	}
	
	

}
