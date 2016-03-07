package com.xt.service.content;

import java.util.List;

import com.xt.bean.Content;
import com.xt.bean.XtParmas;

/**
 * 
 * 查询文章内容接口
 * IContentService
 * 创建人:肖腾
 * 时间：2016年1月11日-上午2:08:34 
 * @version 1.0.0
 *
 */
public interface IContentService {
	
	public List<Content> findContent(XtParmas parmas);
	
	public int countContent(XtParmas parmas);
	
	public int  update(Content content);
	
	public int  delete(XtParmas parmas);

}
