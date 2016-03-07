package com.xt.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

public class GatherContentsUtil {
	private final static Whitelist user_content_filter = Whitelist.relaxed(); 
	static {       
		//增加可信标签到白名单        
		user_content_filter.addTags("embed","object","param","span","div");     //增加可信属性    
		user_content_filter.addAttributes(":all", "style", "class", "id", "name");      
		user_content_filter.addAttributes("object", "width", "height","classid","codebase");      
		user_content_filter.addAttributes("param", "name", "value");      
		user_content_filter.addAttributes("embed", "src","quality","width","height","allowFullScreen","allowScriptAccess","flashvars","name","type","pluginspage"); 
	} 

	public static void main(String[] args) throws MalformedURLException,
			IOException {
		// http://www.xinhuanet.com
		// 1.导入解析包jsoup
		// 2.根据url获取网页的源代码
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
				// String title = document2.getElementById("title").text();
				// String content = document2.getElementById("content").html();
				// String title =
				// document2.getElementsByTag("h1").get(0).text();
				// String content =
				// document2.getElementById("C-Main-Article-QQ").text();
				// String keywords = document2.getElementsByTag("meta").get(2)
				// .attr("content");
				//String description = document2.getElementsByTag("meta").get(2).attr("content");
				String con = Jsoup.clean(document2.getElementById("C-Main-Article-QQ").html(), Whitelist.basic());
			System.out.println(con);

			} catch (Exception e) {
				continue;
			}
		}

	}
}
