package com.xt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * ����������ԴͼƬ
 * LoadNetResources
 * ������:Ф��
 * ʱ�䣺2016��1��22��-����11:56:37 
 * @version 1.0.0
 *
 */
public class LoadNetResources {
	//����������ͼƬ�������ļ�
	public static void downFile(String netpath,String filepath,String fileName){
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			URL url = new URL(netpath);
			URLConnection connection = url.openConnection();
			// ���������Ӷ����л�ȡ�ַ���
			inputStream = connection.getInputStream();
			// ���û�������
			byte[] b = new byte[2014];

			// ��¼���ص�λ��
			int len = 0;
			int loaded = 0;
			int countLength = connection.getContentLength();

			fileOutputStream = new FileOutputStream(new File(filepath, fileName));

			while ((len = inputStream.read(b)) != -1) {
				fileOutputStream.write(b, 0, len);
				loaded+=len;
				System.out.println("�Ѿ�������"+loaded+"byte,��ʣ"+(countLength-loaded)+"byte"+"�ٷֱ��� ��"+(loaded/(float)countLength)*100);
				
				
			}
			System.out.println("������ɣ���");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �������йر�
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
