package com.xt.service.stat;

import java.util.HashMap;
import java.util.List;

import com.xt.bean.XtParmas;
/**
 * 
 * 统计信息的处理
 * IMyStatMapperService
 * 创建人:肖腾
 * 时间：2016年1月15日-上午6:52:51 
 * @version 1.0.0
 *
 */
public interface IMyStatMapperService {
	
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
	 public List<HashMap<String, Object>> groupState(XtParmas parmas);
	 
	 /**
	  * 
	  * (按月份进行统计后台的日志信息)
	  * com.xt.service.stat 
	  * 方法名：groupStatByMonth
	  * 创建人：肖腾
	  * 时间：2016年1月17日-上午1:45:08 
	  * @param parmas
	  * @return List<HashMap<String,Object>>
	  * @exception 
	  * @since  1.0.0
	  */
	 public List<HashMap<String, Object>> groupStatByMonth(XtParmas parmas);
	 
	 
	 /**
	  * (通过月份分组后查询该月份数据的总数)
	  * com.xt.dao.stat 
	  * 方法名：groupStatByMonthCount
	  * 创建人：肖腾
	  * 时间：2016年1月17日-上午3:17:31 
	  * @param parmas
	  * @return int
	  * @exception 
	  * @since  1.0.0
	  */
	 public int groupStatByMonthCount(XtParmas parmas);


}
