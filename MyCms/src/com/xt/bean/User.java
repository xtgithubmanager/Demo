package com.xt.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 用户的实体
 * User
 * 创建人:肖腾
 * 时间：2016年1月1日-下午4:08:26 
 * @version 1.0.0
 *
 */
public class User implements Serializable {

	/**
	 * serialVersionUID:TODO
	 * 
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = 1L;

	// 用户的编号
	private Integer id;

	// 帐号
	private String account;

	// 用户名
	private String username;

	// 用户密码
	private String password;

	// 0代表正常 1代表删除状态
	private Integer isdelete;

	// 对应的用户的地址
	private String address;

	// 用户创建的时间
	private Date createtime;

	// 用户更新的时间
	private Date updatetime;
	
	//用户性别
	private Integer male;
	
	//用户生日
	private Date birthday;
	
	//用户对应的图像
	private String headimg;
	
	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	public User(Integer id, String account, String username, String password,
			Integer isdelete, String address, Date createtime, Date updatetime) {
		super();
		this.id = id;
		this.account = account;
		this.username = username;
		this.password = password;
		this.isdelete = isdelete;
		this.address = address;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	public User() {
		super();
	}

}
