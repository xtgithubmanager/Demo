package com.xt.dao.role;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.bean.Role;
import com.xt.bean.XtParmas;

/**
 * 
 * 后台角色管理
 * IRoleMapper
 * 创建人:肖腾
 * 时间：2016-01-19 14-37-40
 * @version 1.0.0
 *
 */
public interface IRoleMapper {
   
	public List<Role> findRole(XtParmas parmas);
	
	
	public Integer update(Role role);
	
	
	public Integer delete(XtParmas parmas);
	
	
	public int saveUserRole(@Param("userid")Integer userid,@Param("roleid")Integer roleid);
	
	public int saveRolePermission(@Param("roleid")Integer roleid,@Param("permissionid")Integer permissionid);
	
	
	public List<HashMap<String, Object>> findRoleUser(XtParmas parmas);
	
	public Integer findRoleUserCount(XtParmas parmas);
	
	//删除角色的权限
	public Integer deleteRolePermission(@Param("roleid")Integer roleid);
	
	
	public List<HashMap<String, Object>> findPermissionByRole(@Param("roleid")Integer roleid);

}
