package com.xt.service.permission;
import java.util.HashMap;
import java.util.List;

import com.xt.bean.Permission;
import com.xt.bean.XtParmas;

/**
 * 
 * 后台权限管理
 * IPermissionService
 * 创建人:肖腾
 * 时间：2016-01-18 17-31-10
 * @version 1.0.0
 *
 */
public interface IPermissionService {
	/**
	 * 
	 * (查询所有权限的信息)
	 * com.xt.service.permission 
	 * 方法名：findPermission
	 * 创建人：肖腾
	 * 时间：2016年1月18日-下午8:15:39 
	 * @param parmas
	 * @return List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Permission> findPermission(XtParmas parmas);
	
	
	/**
	 * 
	 * (获取权限的结果集)
	 * com.xt.service.permission 
	 * 方法名：findPermissions
	 * 创建人：肖腾
	 * 时间：2016年1月19日-上午11:14:48 
	 * @return HashMap<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */

	HashMap<String, Object> findPermissions(XtParmas parmas);

}
