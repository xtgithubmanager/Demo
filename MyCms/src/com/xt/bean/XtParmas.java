package com.xt.bean;

/**
 * mybatis参数辅助类
 * XtParmas
 * 创建人:肖腾
 * 时间：2016年1月1日-下午3:00:29 
 * @version 1.0.0
 *
 */
public class XtParmas {

	private Integer id;// 主键的查询

	private String password;// 用户的密码

	private String username;// 用户名

	private String account;// 用户帐号

	private Integer channelid;// 用户栏目的id

	private String keywords;// 用户的关键字

	private Integer pageNo = 0;// 分页的起始条数

	private Integer pageSize = 20;// 每页分的条数

	private Integer totalCount = 0;// 分页的总条数
	
 	private String order;//排序
 	
 	private Integer isdelete;//删除状态
 	
 	private String classname;//关于类名
 	
 	private Integer year;//年份  查询该年份的统计信息
 	
 	private Integer month;//查询统计的月份
 	
 	private Integer roleid;
 	

 	
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	
	public Integer getChannelid() {
		return channelid;
	}

	public void setChannelid(Integer channelid) {
		this.channelid = channelid;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public XtParmas() {
		super();
	}

	public XtParmas(Integer id, String password, String username,
			String account, Integer channelid, String keywords, Integer pageNo,
			Integer pageSize, Integer totalCount,String order,Integer isdelete,Integer year,Integer month,Integer roleid) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.account = account;
		this.channelid = channelid;
		this.keywords = keywords;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.order = order;
		this.isdelete = isdelete;
		this.year = year;
		this.month = month;
		this.roleid = roleid;
	}

}
