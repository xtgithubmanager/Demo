package com.xt.ws.impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.apache.struts2.json.JSONUtil;

import com.xt.ws.IRESTSample;
import com.xt.ws.MapBean;
import com.xt.ws.User;
import com.xt.ws.Users;
 
 
/*
     注释（Annotation）：在 javax.ws.rs.* 中定义，是 JAX-RS (JSR 311) 规范的一部分。 
    @Path：定义资源基 URI。由上下文根和主机名组成，资源标识符类似于 http://localhost:8080/RESTful/rest/hello。 
    @GET：这意味着以下方法可以响应 HTTP GET 方法。 
    @Produces：以纯文本方式定义响应内容 MIME 类型。
    
    @Context： 使用该注释注入上下文对象，比如 Request、Response、UriInfo、ServletContext 等。 
    @Path("{contact}")：这是 @Path 注释，与根路径 “/contacts” 结合形成子资源的 URI。 
    @PathParam("contact")：该注释将参数注入方法参数的路径，在本例中就是联系人 id。其他可用的注释有 @FormParam、@QueryParam 等。 
    @Produces：响应支持多个 MIME 类型。在本例和上一个示例中，APPLICATION/XML 将是默认的 MIME 类型。
 */
/**
 * <b>function:</b> CXF RESTful风格WebService
 * @author hoojo
 * @createDate 2012-7-20 下午01:23:04
 * @file RESTSampleSource.java
 * @package com.hoo.service
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@Path(value = "/sample")
public class RESTSampleSourceImpl implements IRESTSample {
    
    @Context
    private UriInfo uriInfo;//解析你的请求地址
    
    @Context
    private Request request;
 
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String doGet() {
        return "this is get rest request";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/request/{param}")
    public String doRequest(@PathParam("param") String param, 
            @Context HttpServletRequest servletRequest, @Context HttpServletResponse servletResponse) {
        System.out.println(servletRequest);
        System.out.println(servletResponse);
        System.out.println("参数是:"+param);
        System.out.println(servletRequest.getContentType());
        System.out.println(servletResponse.getCharacterEncoding());
        System.out.println(servletResponse.getContentType());
        return "success";
    }
    
    @GET
    @Path("/bean/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public User getBean(@PathParam("id") int id) {
        System.out.println("####getBean#####");
        System.out.println("id:" + id);
        System.out.println("Method:" + request.getMethod());
        System.out.println("uri:" + uriInfo.getPath());
        System.out.println(uriInfo.getPathParameters());
        
        User user = new User();
        user.setId(id);
        user.setUsername("JojO");
        return user;
    }
    
    @GET
    @Path("/list")
    @Produces({ MediaType.TEXT_PLAIN})
    public String getList()  {
        System.out.println("####getList#####");
        System.out.println("Method:" + request.getMethod());
        System.out.println("uri:" + uriInfo.getPath());
        System.out.println(uriInfo.getPathParameters());
        
        List<User> list = new ArrayList<User>();
        User user = null;
        for (int i = 0; i < 4;i ++) {
            user = new User();
            user.setId(i);
            user.setAccount("xiaoming-"+i);
            user.setPassword("11111-"+i);
            user.setUsername("JojO-" + i);
            list.add(user);
        }
        Users users = new Users();
        users.setUsers(list);
        try {
        	return JSONUtil.serialize(users);
		} catch (Exception e) {
			return null;
		}
    }
    
    @GET
    @Path("/map")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public MapBean getMap() {
        System.out.println("####getMap#####");
        System.out.println("Method:" + request.getMethod());
        System.out.println("uri:" + uriInfo.getPath());
        System.out.println(uriInfo.getPathParameters());
        
        Map<String, User> map = new HashMap<String, User>();
        User user = null;
        for (int i = 0; i < 4;i ++) {
            user = new User();
            user.setId(i);
            user.setUsername("JojO-" + i);
            map.put("key-" + i, user);
        }
        MapBean bean = new MapBean();
        bean.setMap(map);
        return bean;
    }    
    
    /*
        @Consumes：声明该方法使用 HTML FORM。 
        @FormParam：注入该方法的 HTML 属性确定的表单输入。 
        @Response.created(uri).build()： 构建新的 URI 用于新创建的联系人（/contacts/{id}）并设置响应代码（201/created）。
        您可以使用 http://localhost:8080/Jersey/rest/contacts/<id> 访问新联系人
     */
    @POST
    @Path("/postData")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public User postData(User user) throws IOException {
        System.out.println(user);
        user.setUsername("jojo##12321321");
        return user;
    } 
    
    @PUT
    @Path("/putData/{id}")
    @Produces({ MediaType.APPLICATION_XML })
    public User putData(@PathParam("id") int id, User user) {
        System.out.println("#####putData#####");
        System.out.println(user);
        user.setId(id);
     
        user.setUsername("hoojo");
        System.out.println(user);
        return user;
    }
    
    @DELETE
    @Path("/removeData/{id}")
    public void deleteData(@PathParam("id") int id) {
        System.out.println("#######deleteData#######" + id);
    }
}