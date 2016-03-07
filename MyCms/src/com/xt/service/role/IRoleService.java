package com.xt.service.role;
import java.util.HashMap;
import java.util.List;

import com.xt.bean.Role;
import com.xt.bean.XtParmas;

/**
 * 
 * 后台角色管理
 * IRoleService
 * 创建人:肖腾
 * 时间：2016-01-19 14-37-40
 * @version 1.0.0
 *
 */
public interface IRoleService {
	
	public List<Role> findRole(XtParmas parmas);
	
	public Integer update(Role role);
	
	public Integer delete(XtParmas parmas);
	
	
	public int saveUserRole(Integer userid,Integer roleid);
	
	public List<HashMap<String, Object>> findRoleUser(XtParmas parmas);
	
	public Integer findRoleUserCount(XtParmas parmas);
	
	public int saveRolePermission(Integer roleid,Integer permissionid);
	
	public Integer deleteRolePermission(Integer roleid);
	public List<HashMap<String, Object>> findPermissionByRole(Integer roleid);

}
