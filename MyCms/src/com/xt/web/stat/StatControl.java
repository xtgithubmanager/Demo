package com.xt.web.stat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xt.bean.Stat;
import com.xt.bean.XtParmas;
import com.xt.service.stat.IStatService;

/**
 * 后台日志信息管理
 * StatControl
 * 创建人:肖腾
 * 时间：2016-01-14 05-49-21
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/admin/stat")
public class StatControl {

	@Autowired
	private IStatService statService;

	@RequestMapping("/list")
	public String list(Model model, XtParmas parmas) {
		List<Stat> cons = this.statService.findStat(parmas);
		if (cons.size() > 0) {
			model.addAttribute("stats", cons);
			return "stat/list";
		} else {
			return "error";
		}
	}
	
	@RequestMapping("/userlist")
	public String userlist(Model model, XtParmas parmas) {
		return "/stat/userlist";
	}
	
	

}
