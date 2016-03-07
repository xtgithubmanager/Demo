package com.xt.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xt.bean.User;
import com.xt.util.XtConstant;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("响应渲染成功之后执行的方法");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("请求结束执行的方法");
	}
    
	/*拦截登录*/
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		System.out.println("进入到拦截器进行相应的业务逻辑");
		User user = (User) request.getSession().getAttribute(
				XtConstant.SESSION_USER);
		if (user != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
	}

}
