/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.ws.rmi
 * SpitterService.java
 * 创建人:xuchengfei 
 * 时间：2016年1月6日-下午7:39:52 
 * 2016潭州教育公司-版权所有
 */
package com.xt.ws.rmi;

import org.springframework.stereotype.Service;

/**
 * 
 * SpitterService
 * 创建人:xuchengfei 
 * 时间：2016年1月6日-下午7:39:52 
 * @version 1.0.0
 * 
 */
@Service("spitterService")
public class SpitterServiceImpl implements SpitterService{
	
	public void saveSpitter(){
		System.out.println("调用我了哦");
	}
	
}
