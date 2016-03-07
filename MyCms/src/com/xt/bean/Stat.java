package com.xt.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 后台日志信息管理
 * Stat
 * 创建人:肖腾
 * 时间：2016-01-14 05-49-21
 * @version 1.0.0
 *
 */
public class Stat  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//主键
	private String classname;//名字
	
	
	private String methodname;//方法的名字
	private Long time;//时间
	private Date createtime;//创建的时间
	private String ipaddress;//ip对应的用户的详细地址
	private String ip;//ip地址
	private String model;//模块
	private Integer userid;//用户的id
	private String username;//用户的姓名
	private String description;//描述
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}


	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Stat() {
		super();
	}
	
	public Stat(Integer id, String classname,
			String methodname, Long time, Date createtime,
			String ipaddress, String ip, String model, Integer userid,
			String username, String description) {
		super();
		this.id = id;
		this.classname = classname;
		this.methodname = methodname;
		this.time = time;
		this.createtime = createtime;
		this.ipaddress = ipaddress;
		this.ip = ip;
		this.model = model;
		this.userid = userid;
		this.username = username;
		this.description = description;
	}
	
	

}
