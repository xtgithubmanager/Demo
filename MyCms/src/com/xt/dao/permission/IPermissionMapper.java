package com.xt.dao.permission;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.bean.Permission;
import com.xt.bean.XtParmas;

/**
 * 
 * 后台权限管理
 * IPermissionMapper
 * 创建人:肖腾
 * 时间：2016-01-18 17-31-10
 * @version 1.0.0
 *
 */
public interface IPermissionMapper {

	public List<Permission> findPermission(XtParmas parmas);
	
	/**
	 * 
	 * (查询属性菜单的根节点)
	 * com.xt.dao.permission 
	 * 方法名：findPermissionRoot
	 * 创建人：肖腾
	 * 时间：2016年1月19日-上午10:58:13 
	 * @param parmas
	 * @return List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Permission> findPermissionRoot(XtParmas parmas);
	
	/**
	 * 
	 * (查询根节点子节点的信息)
	 * com.xt.dao.permission 
	 * 方法名：findPermissionChildren
	 * 创建人：肖腾
	 * 时间：2016年1月19日-上午11:01:54 
	 * @param parentId
	 * @return List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Permission> findPermissionChildren(@Param("id")Integer parentId);

}
