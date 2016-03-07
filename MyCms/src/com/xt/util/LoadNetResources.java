package com.xt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * 下载网络资源图片
 * LoadNetResources
 * 创建人:肖腾
 * 时间：2016年1月22日-下午11:56:37 
 * @version 1.0.0
 *
 */
public class LoadNetResources {
	//现在落网的图片和音乐文件
	public static void downFile(String netpath,String filepath,String fileName){
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			URL url = new URL(netpath);
			URLConnection connection = url.openConnection();
			// 从网络连接对象中获取字符流
			inputStream = connection.getInputStream();
			// 设置缓冲区域
			byte[] b = new byte[2014];

			// 记录下载的位置
			int len = 0;
			int loaded = 0;
			int countLength = connection.getContentLength();

			fileOutputStream = new FileOutputStream(new File(filepath, fileName));

			while ((len = inputStream.read(b)) != -1) {
				fileOutputStream.write(b, 0, len);
				loaded+=len;
				System.out.println("已经下载了"+loaded+"byte,还剩"+(countLength-loaded)+"byte"+"百分比是 ："+(loaded/(float)countLength)*100);
				
				
			}
			System.out.println("下载完成！！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 对流进行关闭
			try {
				fileOutputStream.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public static void main(String[] args) {
	  for(int i = 1; i<=10; i++){
		  String mark = i+"";
		  if(i<10)mark="0"+i;
		  String href = "http://luoo-mp3.kssws.ks-cdn.com/low/luoo/radio772/"+mark+".mp3";
		  downFile(href, "D://luoomusic//772", mark+".mp3");
	  }
	}


}
