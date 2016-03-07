package com.xt.web.stat;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.bean.XtParmas;
import com.xt.service.stat.IMyStatMapperService;


@Controller
@RequestMapping("/admin/MyStat")
public class MyStatConstrol {
	
	@Autowired
	private IMyStatMapperService myStatMapperService;
	
	/**
	 * 
	 * (分组后台的日志信息)
	 * com.xt.web.stat 
	 * 方法名：list
	 * 创建人：肖腾
	 * 时间：2016年1月17日-上午1:43:24 
	 * @param parmas
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	@ResponseBody
	@RequestMapping(value="list",method=RequestMethod.POST)
	public List<HashMap<String, Object>> list(XtParmas parmas) {
		List<HashMap<String, Object>> maps = myStatMapperService.groupState(parmas);
		return maps;
	}
	
	
	@ResponseBody
	@RequestMapping(value="contentlist",method=RequestMethod.POST)
	public List<HashMap<String,Object>> contentlist(XtParmas parmas){
		List<HashMap<String,Object>>maps =  myStatMapperService.groupStatByMonth(parmas);
		//获取通过分页查询后数据的总条数
		int count = myStatMapperService.groupStatByMonthCount(parmas);
		HashMap<String,Object> countMap = new HashMap<String,Object>();
		countMap.put("ccount", count);
		maps.add(countMap);
		return maps;
	}

}
