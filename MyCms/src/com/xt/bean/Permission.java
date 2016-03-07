package com.xt.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 后台权限管理
 * Permission
 * 创建人:肖腾
 * 时间：2016-01-18 17-31-10
 * @version 1.0.0
 *
 */
public class Permission  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//主键
	private String name;//名字
	private Date createtime;//创建时间
	private Date updatetime;//更新时间
	private Integer isdelete;//删除状态
	private String description;//描述
	private String url;//访问的url地址
	private String model;//对应模块的名称
	private Integer parentid;//对应父id 用于多级的展示
	private Integer userid;//用户的id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public Permission() {
		super();
	}
	public Permission(Integer id, String name, Date createtime,
			Date updatetime, Integer isdelete, String description, String url,
			String model, Integer parentid, Integer userid) {
		super();
		this.id = id;
		this.name = name;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isdelete = isdelete;
		this.description = description;
		this.url = url;
		this.model = model;
		this.parentid = parentid;
		this.userid = userid;
	}

	 
	
}
