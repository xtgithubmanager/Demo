package com.xt.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 后台角色管理
 * Role
 * 创建人:肖腾
 * 时间：2016-01-19 14-37-40
 * @version 1.0.0
 *
 */
public class Role  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//主键
	private String name;//名字
	private Date createtime;//创建时间
	private Date updatetime;//更新时间
	private Integer isdelete;//删除状态
	private Integer status;//发布的状态	
	private String description;//描述
	private Integer userid;//对应用户的id
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
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

	public Role(Integer id, String name, Date createtime, Date updatetime,
			Integer isdelete,Integer status,String description,Integer userid) {
		super();
		this.id = id;
		this.name = name;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.isdelete = isdelete;
        this.status = status;
        this.description = description;
        this.userid = userid;
	}
	public Role() {
		super();
	}
	
	
	
}
