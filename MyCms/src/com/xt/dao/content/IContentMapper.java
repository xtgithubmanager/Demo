package com.xt.dao.content;

import java.util.List;

import com.xt.bean.Content;
import com.xt.bean.XtParmas;

/**
 * 
 * 内容的操作
 * IContentMapper
 * 创建人:肖腾
 * 时间：2016年1月11日-上午12:48:49 
 * @version 1.0.0
 *
 */
public interface IContentMapper {

	public List<Content> findContent(XtParmas parmas);
	
	public int countContent(XtParmas parmas);
	
	public int  update(Content content);
	
	public int  delete(XtParmas parmas);
	
	public int saveContent(Content content);

}
