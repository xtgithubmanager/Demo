package com.xt.service.permission.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.bean.Permission;
import com.xt.bean.XtParmas;
import com.xt.dao.permission.IPermissionMapper;
import com.xt.service.permission.IPermissionService;

/**
 * 
 * 后台权限管理
 * PermissionServiceImp;
 * 创建人:肖腾
 * 时间：2016-01-18 17-31-10
 * @version 1.0.0
 *
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private IPermissionMapper permissionMapper;
	
	@Override
	public List<Permission> findPermission(XtParmas parmas) {
		return permissionMapper.findPermission(parmas);
	}

    
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
	TreeMap<String,List<HashMap<String, Object>>> childrenMap = null;
	@Override
	public HashMap<String, Object> findPermissions(XtParmas parmas) {
		HashMap<String, Object> datas = new HashMap<>();
		//装载所有的子元素
		childrenMap = new TreeMap<>();
		// 查询根节点的信息
		List<Permission> perroots = permissionMapper.findPermissionRoot(parmas);
		if (perroots != null && perroots.size() > 0) {
			List<HashMap<String, Object>> maps = new ArrayList<>();
		    for (Permission permission : perroots) {
				HashMap<String, Object> map = new HashMap<String,Object>();
				map.put("name", permission.getName());
				map.put("url", "javascript:void(0);");
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				//将对应的map加入到对应的list中去
				maps.add(map);
				getChildrenData(permission.getId());
			}
			datas.put("root", maps);
			datas.put("children", childrenMap);
			return datas;
		} else {
			return null;
		}
	}
	
	//通过父id查询子节点的信息(循环的查出子类的信息)
	public void getChildrenData(Integer parentId) {
		// 查询出所有子类的信息
		List<Permission> childrenpermissions = permissionMapper.findPermissionChildren(parentId);
		if (childrenpermissions != null && childrenpermissions.size() > 0) {
			List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
			for (Permission permission : childrenpermissions) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("name", permission.getName());
				map.put("url", "javascript:void(0);");
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				// 将对应的map加入到对应的list中去
				maps.add(map);
				// 继续查询对应的子类的信息
				getChildrenData(permission.getId());
			}

			childrenMap.put(parentId + "", maps);

		}
	}
	
	

	
}
