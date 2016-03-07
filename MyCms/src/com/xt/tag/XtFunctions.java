package com.xt.tag;

import java.util.Date;

import com.xt.util.TmStringUtils;



public class XtFunctions {
	
	 /**
	  * 
	  * (自定义标签转换日期格式的函数)
	  * com.xt.tag 
	  * 方法名：formatdate
	  * 创建人：肖腾
	  * 时间：2016年1月12日-下午11:23:29 
	  * @param date
	  * @param pattern
	  * @return String
	  * @exception 
	  * @since  1.0.0
	  */
	public static String formatdate(Date date,String pattern ){
		return TmStringUtils.formatDate(date, pattern);
	}
	
	
	/**
	 * 
	 * (自定义标签转换中文日期格式)
	 * com.xt.tag 
	 * 方法名：getTimeFormat
	 * 创建人：肖腾
	 * 时间：2016年1月12日-下午11:24:15 
	 * @param startTime
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//秒
			long day_diff  = (long) Math.floor(diff/86400);//天
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],时间越界...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"秒前");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 分钟前");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"分钟前");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1小时前");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"小时前");
				}else if(day_diff==1){
					buffer.append("1天前");
				}else if(day_diff<7){
					buffer.append(day_diff+"天前");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " 星期前");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "月前");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("半年前");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"年前");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
	
    /**
     * 
     * (索引一个字符串在另外一个字符串中是否存在)
     * com.xt.tag 
     * 方法名：indexOf
     * 创建人：肖腾
     * 时间：2016年1月12日-下午11:27:07 
     * @param content
     * @param searchContent
     * @return int
     * @exception 
     * @since  1.0.0
     */
	public static int indexOf(String content,String searchContent){	
		return content.indexOf(searchContent);
	}
	
}
