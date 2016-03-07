package com.xt.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xt.bean.User;
import com.xt.bean.XtParmas;
/**
 * 
 * 用户的的服务层
 * IUserService
 * 创建人:肖腾
 * 时间：2016年1月1日-下午4:17:40 
 * @version 1.0.0
 *
 */
@Service
public interface IUserService {
    /**
     * 
     *用户查询
     * com.xt.service.user 
     * 方法名：findUser
     * 创建人：肖腾
     * 时间：2016年1月1日-下午4:18:05 
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
