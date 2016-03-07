<%@ page language="java" import="java.util.*,com.xt.cut.*"
	pageEncoding="utf-8"%>
<%
	//获取服务器的绝对路径
	String relpath = request.getRealPath("/");//获取服务器的绝对路径
	//裁剪以后小图片的名称
	String filename = new Date().getTime() + ".jpg";
	String srcpath = request.getParameter("cutImg");//原图片相对的路径

	String src = relpath + srcpath;//原图片的绝对路径

	String targetPath = relpath + "/images/" + filename;

	String x = request.getParameter("x");//x坐标
	String y = request.getParameter("y");//y坐标
	String w = request.getParameter("w");//裁剪图片的宽度
	String h = request.getParameter("h");//裁剪图片的高度

	try {
		CutUtil.cutImg(src, targetPath, Integer.parseInt(x),
				Integer.parseInt(y), Integer.parseInt(w),
				Integer.parseInt(h));
		//在网页打印出对应的图片
		out.print("<img src='images/" + filename + "'/>");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.print("截取对应的图片失败");
	}
%>

