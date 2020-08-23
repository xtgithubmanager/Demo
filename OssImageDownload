package com.xt.test;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ExTest {
    public static void main(String[] args)  throws IOException {
        String ec = URLEncoder.encode("身份证_");
        String url = "https://lcapi.midea.com/api-file/ossDown/221E3F05DE3A467DA9B2F79682D750E9/srm/%E8%BA%AB%E4%BB%BD%E8%AF%81_1586569761026.jpg";
        byte[] bb = getFile(url);
        System.out.println("----:"+bb.length);
    }
    private static byte[] getFile(String url) throws IOException {
        String downLoadUrl =  getRealPath(url);
        URL urlConet = new URL(downLoadUrl);
        HttpURLConnection con = (HttpURLConnection)urlConet.openConnection();
        InputStream inStream = con.getInputStream();    //通过输入流获取图片数据
        int code = con.getResponseCode();
        System.out.println("响应码是："+code);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        byte[] data =  outStream.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        String str =  encoder.encode(data);
        System.out.println("data:image/jpg;base64,"+str);
        return data;
    }


    public static String getRealPath(String sourcePath){
        String location = "";
        try {
            System.out.println("访问地址:" + sourcePath);
            URL serverUrl = new URL(sourcePath);
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            // 必须设置false，否则会自动redirect到Location的地址
            conn.setInstanceFollowRedirects(false);

            conn.addRequestProperty("Accept-Charset", "UTF-8;");
            conn.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
            conn.addRequestProperty("Referer",sourcePath);
            conn.connect();
            location = conn.getHeaderField("Location");

            serverUrl = new URL(location);
            conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");

            conn.addRequestProperty("Accept-Charset", "UTF-8;");
            conn.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
            conn.addRequestProperty("Referer", sourcePath);
            conn.connect();
            System.out.println("跳转地址:" + location);

        }catch (Exception e){
            e.printStackTrace();
        }
        return location;
    }
}
