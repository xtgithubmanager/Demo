package com.xt.web.permission;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.bean.Permission;
import com.xt.bean.XtParmas;
import com.xt.service.permission.IPermissionService;

/**
 * 后台权限管理
 * PermissionControl
 * 创建人:肖腾
 * 时间：2016-01-18 17-31-10
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/admin/permission")
public class PermissionControl {

	@Autowired
	private IPermissionService permissionService;

	@RequestMapping("/list")
	public String list(Model model, XtParmas parmas) {
		List<Permission> cons = this.permissionService.findPermission(parmas);
		if (cons.size() > 0) {
			model.addAttribute("permissions", cons);
			return "permission/list";
		} else {
			return "error";
		}
	}
	
	//查询根节点的信息
	@RequestMapping(value="/getroot")
	@ResponseBody
	public HashMap<String, Object> getroot(Model model,XtParmas parmas){
		HashMap<String, Object> map = permissionService.findPermissions(parmas);
		return map;
	}

}
