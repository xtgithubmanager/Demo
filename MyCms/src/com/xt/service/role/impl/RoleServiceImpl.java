package com.xt.service.role.impl;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.bean.Role;
import com.xt.bean.XtParmas;
import com.xt.dao.role.IRoleMapper;
import com.xt.service.role.IRoleService;

/**
 * 
 * 后台角色管理
 * RoleServiceImp;
 * 创建人:肖腾
 * 时间：2016-01-19 14-37-40
 * @version 1.0.0
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleMapper roleMapper;
	
	@Override
	public List<Role> findRole(XtParmas parmas) {
		return roleMapper.findRole(parmas);
	}

	@Override
	public Integer update(Role role) {
		return roleMapper.update(role);
	}

	@Override
	public Integer delete(XtParmas parmas) {
		return roleMapper.delete(parmas);
	}

	@Override
	public int saveUserRole(Integer userid, Integer roleid) {
		return roleMapper.saveUserRole(userid, roleid);
	}

	@Override
	public List<HashMap<String, Object>> findRoleUser(XtParmas parmas) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleUser(parmas);
	}

	@Override
	public Integer findRoleUserCount(XtParmas parmas) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleUserCount(parmas);
	}

	@Override
	public int saveRolePermission(Integer roleid, Integer permissionid) {
		// TODO Auto-generated method stub
		return roleMapper.saveRolePermission(roleid, permissionid);
	}

	@Override
	public Integer deleteRolePermission(Integer roleid) {
		return roleMapper.deleteRolePermission(roleid);
	}

	@Override
	public List<HashMap<String, Object>> findPermissionByRole(Integer roleid) {
		// TODO Auto-generated method stub
		return roleMapper.findPermissionByRole(roleid);
	}
}
