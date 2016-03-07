package com.xt.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 用户的实体
 * User
 * 创建人:肖腾
 * 时间：2016年1月1日-下午4:08:26 
 * @version 1.0.0
 *
 */

@XmlRootElement(name="userInfo")
public class User  implements Serializable{

	/**
	 * serialVersionUID:TODO
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = 1L;
   
	//用户的编号
	private Integer id;
   
	//帐号
	private String account;

	//用户名
	private String username;

	//用户密码
	private String password;
	
	//0代表正常  1代表删除状态
	private Integer isdelete;
	
	  

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public User(Integer id, String account, String username, String password,Integer isdelete) {
		super();
		this.id = id;
		this.account = account;
		this.username = username;
		this.password = password;
		this.isdelete = isdelete;
	}

	public User() {
		super();
	}

}
