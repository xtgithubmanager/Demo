package com.xt.web.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.xt.bean.User;
import com.xt.bean.XtParmas;
import com.xt.core.BaseController;
import com.xt.service.user.IUserService;
import com.xt.util.TmStringUtils;
import com.xt.util.XtConstant;

@Controller
public class UserControl extends BaseController {

	@Autowired
	private IUserService userService;

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	/**
	 * 用户登录 com.xt.web 
	 * 方法名：logined 
	 * 创建人：肖腾
	 * 时间：2016年1月1日-下午5:34:35
	 * @param parmas
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	@ResponseBody
	@RequestMapping(value = "logined", method = RequestMethod.POST)
	public String logined(XtParmas parmas,HttpServletRequest request) {
		if (parmas != null) {
			if (TmStringUtils.isNotEmpty(parmas.getAccount())&& TmStringUtils.isNotEmpty(parmas.getPassword())) {
				parmas.setPassword(TmStringUtils.md5Base64(parmas.getPassword()));
				 
			    //获取前台传入的验证码
				String code = request.getParameter("code");
				if(TmStringUtils.isNotEmpty(code)){
					//获取session中存储的验证码
					String sessioncode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
					if(TmStringUtils.isNotEmpty(sessioncode)&&!code.equalsIgnoreCase(sessioncode)){
						return "code_error";
					}
				}
				User user = userService.findUser(parmas);
				if (user != null) {
					//讲用户的信息和request对象存储(用户后台日志记录)
					request.getServletContext().setAttribute("user_log", user);
					request.getServletContext().setAttribute("request_log",request);
					// 将用户信息存储到session
					session.setAttribute(XtConstant.SESSION_USER, user);
					session.setAttribute(XtConstant.SESSION_USER_USERNAME,
							user.getUsername());
					return "success";
				} else {
					return "fail";
				}
			} else {
				return "null";// 请输入对应的帐号和密码
			}
		} else {
			return "error";
		}
	}

	/**
	 * 
	 * (注销登录)
	 * com.xt.web.user 
	 * 方法名：loginout
	 * 创建人：肖腾
	 * 时间：2016年1月13日-上午4:57:52 
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/loginout")
	public String loginout() {
		
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
}
