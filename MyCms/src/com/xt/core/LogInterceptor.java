package com.xt.core;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.xt.bean.Stat;
import com.xt.bean.User;
import com.xt.dao.stat.IStatMapper;
import com.xt.util.TmStringUtils;
import com.xt.util.ip.TmIpUtil;

/**
 * 
 * 日志记录的拦截器
 * LogInterceptor
 * 创建人:肖腾
 * 时间：2016年1月13日-上午10:46:05 
 * @version 1.0.0
 *
 */

@Aspect
public class LogInterceptor implements ServletContextAware{
	
	private ServletContext application;
	
	@Autowired
	private IStatMapper statMapper;

	@Around("execution(* com.xt.service.*.*.*(..))")//环绕通知
	public Object doBasicProfiling(ProceedingJoinPoint point) throws Throwable {
		//获取到后台执行的方法
		String methodName = point.getSignature().getName();
	    if(TmStringUtils.isNotEmpty(methodName) && methodName.equals("findUser")){
	    	return point.proceed(); 
	    }	
	    
		// 执行该方法
		Object classObj = point.getTarget();//获取当前执行方法的类名
		long start = System.currentTimeMillis();//获取当前系统的执行时间
		Object object = point.proceed();
		long end = System.currentTimeMillis();
		//获取执行的方法
		long time = (end -start);
		//获取对应的方法的参数
		Object[] params = point.getArgs();
		StringBuilder builder = new StringBuilder("");
		if(params.length>0){
			for (int i = 0; i < params.length; i++) {
				builder.append(String.valueOf(params[i]));
				if(i<params.length-1){
					builder.append(",");
				}
			}
		}
		
		//执行的类的名称
		String className = classObj.getClass().getName();
		//返回类型
		String returnType = null;
		if(object!=null){
			returnType = object.getClass().getName();
		}
		
		
//		User user = (User)application.getAttribute("user_log");
//		HttpServletRequest request = (HttpServletRequest)application.getAttribute("request_log");
//		System.out.println("操作用户id是："+user.getId());
//		System.out.println(user.getUsername());
//	    System.out.println("操作的ip是："+TmIpUtil.getIpAddress(request));
//	    System.out.println(TmIpUtil.ipLocation(request));
		System.out.println("【记录后台的日志】【Service AOP拦截】【Class："+className+"】【Method："+methodName+"】【ReturnType："+returnType+"】【Time："+time+"ms】");
		//保存日记到数据库
		try{
			saveLog(className,methodName,time);
		}catch(Exception e){
			
		}
		return object;
	}

	@Override
	public void setServletContext(ServletContext application) {
	   this.application = application;
	}
	
	private void saveLog(String classname,String methodname,long time){
		Stat stat = new Stat();
		User user = (User) application.getAttribute("user_log");
		HttpServletRequest request = (HttpServletRequest) application
				.getAttribute("request_log");
		stat.setClassname(classname);
		stat.setUserid(user.getId());
		stat.setMethodname(methodname);
		stat.setTime(time);
		stat.setIp(TmIpUtil.getIpAddress(request));
		stat.setIpaddress(TmIpUtil.ipLocation(request));
		stat.setUsername(user.getUsername());
		stat.setModel("content");
		stat.setDescription("content");
		statMapper.save(stat);
	}
}
