package com.xt.web.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.bean.Content;
import com.xt.bean.XtParmas;
import com.xt.service.content.IContentService;

/**
 * 文章内容的控制层
 * ContentControl
 * 创建人:肖腾
 * 时间：2016年1月11日-上午5:02:15 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/admin/content")
public class ContentControl {

	@Autowired
	private IContentService contentService;

	@RequestMapping("/list")
	public String list(Model model, XtParmas parmas) {
		List<Content> cons = this.contentService.findContent(parmas);
		int count = this.contentService.countContent(parmas);
		if (cons.size() > 0) {
			model.addAttribute("contents", cons);
			model.addAttribute("count", count);
			return "content/list";
		} else {
			return "error";
		}
	}
	
	@RequestMapping("/template")
	public String template(Model model, XtParmas parmas) {
		parmas.setIsdelete(0);
		List<Content> cons = this.contentService.findContent(parmas);
		int count = this.contentService.countContent(parmas);
		if (cons.size() > 0) {
			model.addAttribute("contents", cons);
			model.addAttribute("count", count);
			return "content/template";
		} else {
			return "error";
		}
	}
	
	/**
	 * 
	 * (更新内容的信息)
	 * com.xt.web.content 
	 * 方法名：update
	 * 创建人：肖腾
	 * 时间：2016年1月13日-上午4:40:52 
	 * @param content
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(Content content){
		contentService.update(content);
		return "success";
	}
	
	/**
	 * 
	 * (对应的删除内容的信息)
	 * com.xt.web.content 
	 * 方法名：delete
	 * 创建人：肖腾
	 * 时间：2016年1月13日-上午8:22:35 
	 * @param parmas
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(XtParmas parmas){
		contentService.delete(parmas);
		return "success";
	}
}
