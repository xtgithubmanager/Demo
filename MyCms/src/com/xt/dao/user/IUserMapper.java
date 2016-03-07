package com.xt.dao.user;

import java.util.List;

import com.xt.bean.User;
import com.xt.bean.XtParmas;

/**
 * 
 * 用户类
 * IUserMapper
 * 创建人:肖腾
 * 时间：2016年1月1日-下午2:43:56 
 * @version 1.0.0
 *
 */
public interface IUserMapper {
	/**
	 * 
	 * 用户查询
	 * com.xt.dao.user 
	 * 方法名：findUser
	 * 创建人：肖腾
	 * 时间：2016年1月1日-下午4:18:33 
	 * @param parmas
	 * @return User
	 * @exception 
	 * @since  1.0.0
	 */
	
	public User findUser(XtParmas parmas);
	
	public List<User> findAllUser(XtParmas parmas);
	
	public int countUser(XtParmas parmas);
	
	public int update(User user);
	
	public int delete(XtParmas parmas);

}
