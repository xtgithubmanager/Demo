package com.xt.bean;

import java.io.Serializable;

/**
 * 
 * 栏目对应的实体类
 * channel
 * 创建人:肖腾
 * 时间：2016年1月11日-上午12:19:57 
 * @version 1.0.0
 *
 */
public class Channel implements Serializable {
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;//栏目的id
	private String name;//栏目的名称
	private String description;//栏目的描述
	private Integer userid;//栏目的用户id
	private Integer isdelete;//栏目是否删除
	private Integer sort;//栏目对应的序号
	private String model;//对应的实体模型
	private String url;//对应的权限访问url
	private Integer parentid;//父id针对子的栏目
	
	
    
	public Integer getParentid() {
		return parentid;
	}
	

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

	public Channel() {
		super();
	}

	public Channel(Integer id, String name, String description, Integer userid,
			Integer isdelete, Integer sort, String model, String url,Integer parentid) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.userid = userid;
		this.isdelete = isdelete;
		this.sort = sort;
		this.model = model;
		this.url = url;
		this.parentid = parentid;
	}
}
