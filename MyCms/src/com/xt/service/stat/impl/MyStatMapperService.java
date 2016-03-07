package com.xt.service.stat.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.bean.XtParmas;
import com.xt.dao.stat.IMyStatMapper;
import com.xt.service.stat.IMyStatMapperService;
/**
 * 
 * 统计信息的处理
 * MyStatMapperService
 * 创建人:肖腾
 * 时间：2016年1月15日-上午6:55:05 
 * @version 1.0.0
 *
 */
@Service
public class MyStatMapperService implements IMyStatMapperService {
	
	@Autowired
	private IMyStatMapper myStatMapper;
	
	/**
	 * 
	 * (按照年份统计后台日志的系信息)
	 * com.xt.service.stat 
	 * 方法名：groupState
	 * 创建人：肖腾
	 * 时间：2016年1月15日-上午6:53:06 
	 * @param parmas
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public List<HashMap<String, Object>> groupState(XtParmas parmas) {
		return myStatMapper.groupState(parmas);
	}
	
	
	@Override
	public List<HashMap<String, Object>> groupStatByMonth(XtParmas parmas) {
		return  myStatMapper.groupStatByMonth(parmas);
	}


	@Override
	public int groupStatByMonthCount(XtParmas parmas) {
		return myStatMapper.groupStatByMonthCount(parmas);
	}
	
	

}
