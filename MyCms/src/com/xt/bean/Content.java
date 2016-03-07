package com.xt.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 对应的实体内容
 * content
 * 创建人:肖腾
 * 时间：2016年1月11日-上午12:23:48 
 * @version 1.0.0
 *
 */
public class Content  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//主键
	private String  title;//对应的标题
	private String subtitle;//子标题	
	private String content;//文章对应的内容
    private Date createtime;//创建的时间
	private Date updatetime;//更新的时间
	private Integer userid;//用户对应的id
	private Integer istop;//文章置顶的操作
	private Integer isdelete;//文章删除的状态 0代表未删除 1代表删除
	private Integer status;//文章的状态
	private Integer channelid;//文章对应的栏目id
	private String  img;//文章对应的图片
	private Integer push;
	private Integer iscomment;//文章是否进行评论
	private Integer hits;//文章的点击数
	private Integer loves;//赞数
	private Integer collections;//收藏数
	private String staticlink;//文章的静态化连接
	private String keywords;//文章的关键字
	private String description;//文章的描述
	private String thumnail;//缩略图
	
	
	private String type;
	private Integer categoryid;
	
	private String tag;//文章的标签
	
	private String comment;//文章的评论内容
	
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getIstop() {
		return istop;
	}
	public void setIstop(Integer istop) {
		this.istop = istop;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getChannelid() {
		return channelid;
	}
	public void setChannelid(Integer channelid) {
		this.channelid = channelid;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getPush() {
		return push;
	}
	public void setPush(Integer push) {
		this.push = push;
	}
	public Integer getIscomment() {
		return iscomment;
	}
	public void setIscomment(Integer iscomment) {
		this.iscomment = iscomment;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getLoves() {
		return loves;
	}
	public void setLoves(Integer loves) {
		this.loves = loves;
	}
	public Integer getCollections() {
		return collections;
	}
	public void setCollections(Integer collections) {
		this.collections = collections;
	}
	public String getStaticlink() {
		return staticlink;
	}
	public void setStaticlink(String staticlink) {
		this.staticlink = staticlink;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Content(String title, String subtitle, String content,
			Date createtime, Date updatetime, Integer userid, Integer istop,
			Integer isdelete, Integer status, Integer channelid, String img,
			Integer push, Integer iscomment, Integer hits, Integer loves,
			Integer collections, String staticlink, String keywords,
			String description,String thumnail,String type,Integer categoryid,String tag,String comment) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.userid = userid;
		this.istop = istop;
		this.isdelete = isdelete;
		this.status = status;
		this.channelid = channelid;
		this.img = img;
		this.push = push;
		this.iscomment = iscomment;
		this.hits = hits;
		this.loves = loves;
		this.collections = collections;
		this.staticlink = staticlink;
		this.keywords = keywords;
		this.description = description;
		this.thumnail = thumnail;
		this.categoryid = categoryid;
		this.tag = tag;
		this.comment = comment;
	}
	
	public Content() {
		super();
	}
	
	
	
	


}
