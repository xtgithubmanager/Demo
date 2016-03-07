package com.xt.ws;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
 
/**
 * <b>function:</b> MapBean 封装Map集合元素
 * @author hoojo
 * @createDate 2012-7-20 下午01:22:31
 * @file MapBean.java
 * @package com.hoo.entity
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@XmlRootElement
public class MapBean {
    private Map<String, User> map;
    
    //@XmlElement(type = User.class)
    public Map<String, User> getMap() {
        return map;
    }
    public void setMap(Map<String, User> map) {
        this.map = map;
    }
}
 