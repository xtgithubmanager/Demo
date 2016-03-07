package com.xt.ptest;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xt.bean.Content;
import com.xt.bean.Permission;
import com.xt.bean.Role;
import com.xt.bean.Stat;
import com.xt.bean.User;
import com.xt.bean.XtParmas;
import com.xt.dao.content.IContentMapper;
import com.xt.dao.permission.IPermissionMapper;
import com.xt.dao.role.IRoleMapper;
import com.xt.dao.stat.IMyStatMapper;
import com.xt.dao.stat.IStatMapper;
import com.xt.dao.user.IUserMapper;
import com.xt.service.permission.IPermissionService;
import com.xt.service.role.IRoleService;
import com.xt.service.user.IUserService;
import com.xt.util.TmStringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DataSourceTest {
    
	@Autowired
	private IUserMapper userMapper;//对应的已经不是接口 得到的是一个代理的接口

	
	@Autowired
	private IUserService service;
	
	@Autowired
	private IContentMapper contentMapper;
	
	@Autowired
	private IStatMapper statMapper;
	
	@Autowired
	private IPermissionMapper permissionMapper;
	
	@Autowired
	private IMyStatMapper myStatMapper;
	
	@Autowired
	private IPermissionService permissionService;
	
	@Autowired
	private IRoleMapper roleMapper;
	
	@Autowired
	private IRoleService roleService;
	
	@Test
	public void testXonnect() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");		
		System.out.println("初始化对应的对象："+userMapper);
		 
		XtParmas parmas = new XtParmas();
		parmas.setAccount("xiaoteng");
		parmas.setPassword("Jh4W7UQlaRQ=");
		User user =  userMapper.findUser(parmas);
		System.out.println(user.getAccount()+"====="+user.getUsername());
	}
	
	@Test
	public void testContent(){
//		List<Content> conns =  contentMapper.findContent(f);
//		for (Content content : conns) {
//			System.out.println("-------------xiaoxiao------------"+content.getTitle()+"-----"+content.getCreatetime());
//		}
	}
	
	@Test
	public void testContent2(){
		int a  = contentMapper.countContent(null);
		System.out.println("++++++++++++:"+a);
	}
	
	@Test
	public void testUser1(){
		XtParmas parmas = new XtParmas();
		List<User>users =  userMapper.findAllUser(parmas);
		for (User user : users) {
			System.out.println(user.getUsername()+"======="+user.getAccount());
		}
	}
	
	@Test
	public void testUser2(){
		XtParmas parmas = new XtParmas();
		int a =  userMapper.countUser(parmas);
		System.out.println("-----------------------:"+a);
	}
	
	
	@Test
	public void testXonnect1(){
		XtParmas parmas = new XtParmas();
		parmas.setAccount("xiaoteng");
		parmas.setPassword("Jh4W7UQlaRQ=");
		User user =  service.findUser(parmas);
		System.out.println(user.getAccount()+"====="+user.getUsername());
	}
	
	//测试更新内容的信息  删除
	@Test
	public void testConUpdate(){
		Content content = new Content();
		content.setId(1);
		content.setIsdelete(1);
		content.setStatus(0);
		content.setPush(1);
		int a = contentMapper.update(content);
		System.out.println("更新的数据是："+a);
	}
	
	//删除
	@Test
	public void testdeletecon(){
		XtParmas parmas = new XtParmas();
		parmas.setId(1);
		int a  = contentMapper.delete(parmas);
		System.out.println("更新的数据是："+a);
	}
	
	
	@Test
	public void testD(){
		Stat stat = new Stat();
		stat.setClassname("ssss");
		int count = statMapper.save(stat);
		System.out.println(count);
	}
	
	/**
	 * 
	 * (测试统计的信息)
	 * com.xt.ptest 
	 * 方法名：testTj
	 * 创建人：肖腾
	 * 时间：2016年1月15日-上午6:43:28  void
	 * @throws JSONException 
	 * @exception 
	 * @since  1.0.0
	 */
	@Test
	public void testTj() throws JSONException{
		XtParmas parmas = new XtParmas();
		parmas.setMonth(1);
		int a =  myStatMapper.groupStatByMonthCount(parmas);
		System.out.println("数据的总数是:"+a);
	}
	
	@Test
	public void test5(){
		XtParmas parmas = new XtParmas();
		List<Permission>pers =  permissionMapper.findPermissionRoot(parmas);
		for (Permission permission : pers) {
			System.out.println(permission.getName()+"==="+permission.getUrl());
		}
		System.out.println("所有的权限："+pers);
		
	}
	
	@Test
	public void test6() {
		List<Permission> permissions = permissionMapper
				.findPermissionChildren(1);
		for (Permission permission : permissions) {
			System.out.println(permission.getName() + "<===>"
					+ permission.getUrl());
		}

	}
	
	
	@Test
	public void test7(){
		XtParmas parmas = new XtParmas();
		HashMap<String,Object> map =  permissionService.findPermissions(parmas);
		System.out.println("map------------:"+map);
	}
	
	@Test
	public void test8(){
		Role role = new Role();
		role.setId(1);
		role.setIsdelete(1);
		roleMapper.update(role);
	}
	
	@Test
	public void test9(){
		XtParmas parmas = new XtParmas();
		parmas.setRoleid(1);
		List<HashMap<String, Object>> roles =  roleMapper.findRoleUser(parmas);
		System.out.println(roles);
	}
	
	
	@Test
	public void test10(){
		XtParmas parmas = new XtParmas();
		parmas.setRoleid(1);
		int b =   roleMapper.findRoleUserCount(parmas);
		System.out.println("count:"+b);
	}
	
	@Test
	public void test11(){	
		int a = roleMapper.saveRolePermission(1, 2);
		System.out.println("添加成功："+a);
	}
	
	@Test
	public void test12(){
		List<HashMap<String, Object>> lists = roleMapper.findPermissionByRole(1);
		System.out.println("lists:"+lists);
	}
	
	
	/**
	 * 
	 * (采集网页的数据)
	 * com.xt.ptest 
	 * 方法名：findContent
	 * 创建人：肖腾
	 * 时间：2016年1月22日-上午2:22:58  void
	 * @exception 
	 * @since  1.0.0
	 */
	@Test
	public void findContent() {
		
		try {
			Document document = Jsoup.parse(new URL("http://www.qq.com"), 3000);
			// System.out.println(document);

			Elements elements = document.getElementsByTag("a");

			Set<String> urls = new HashSet<String>();
			for (Element element : elements) {
				String href = element.attr("href");
				if (TmStringUtils.isNotEmpty(href)
						&& href.startsWith("http://news.qq.com/")) {
					urls.add(href + "\n");
				}
			}

			// 解析匹配出来的url
			for (String string : urls) {
				try {
					Document document2 = Jsoup.parse(new URL(string), 4000);
					String title = document2.getElementsByTag("h1").get(0)
							.text();//获取该网站的标题
					String con =document2.getElementById("C-Main-Article-QQ").html();//获取文章的内容
					//String con = Jsoup.clean(document2.getElementById("C-Main-Article-QQ").html(), Whitelist.basic());
					String keywords = document2.getElementsByTag("meta").get(2)
							.attr("content");//获取文章的搜索关键字
					String description = document2.getElementsByTag("meta")
							.get(3).attr("content");//获取文章的描述
					Content content = new Content();
					content.setKeywords(keywords);
					content.setTitle(title);
					content.setDescription(description);
					content.setContent(con);
					content.setHits(0);
					content.setIscomment(0);
					content.setIstop(0);
					content.setIsdelete(0);
					content.setUserid(1);

					contentMapper.saveContent(content);
					System.out.println("保存成功");
				} catch (Exception e) {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	

}
