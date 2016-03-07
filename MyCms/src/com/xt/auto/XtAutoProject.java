package com.xt.auto;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.xt.util.TmFileUtil;
import com.xt.util.TmStringUtils;

/**
 * 针对个人项目自动生成类  实现一次性敏捷式的构建
 * XtAutoProject
 * 创建人:肖腾
 * 时间：2016年1月11日-上午6:24:56 
 * @version 1.0.0
 *
 */
public class XtAutoProject {
	
	//定义对应实体类的名字
	private static String beanName = "Role";//大写beanName
	private static String smallBeanName = beanName.toLowerCase();//小写beanName
	
	//文件生成的目录结构
	private static String srcPath = "src/";
	private static String beanPath = "com/xt/bean/";
	private static String daoPath = "com/xt/dao/";
	private static String servicePath = "com/xt/service/";
	private static String serviceImplPath = "com/xt/service/"+smallBeanName+"/impl/";
	private static String webPath = "com/xt/web/"+smallBeanName+"/";
	private static String pagePath = "/WebRoot/WEB-INF/pages/"+smallBeanName+"/";
	
	//模版的目录及其文件信息
	private static String beanTemplate = "template/bean.txt";
	private static String daoTemplate = "template/mapper.txt";
	private static String xmlTemplate = "template/sql.txt";
	private static String serviceTemplate = "template/service.txt";
	private static String serviceImplTemplate = "template/serviceImpl.txt";
	private static String webTemplate = "template/web.txt";
	private static String pageTemplate = "template/list.txt";
	private static String tableTemplate = "template/table.sql";
	
	//包名
	private static String beanPackageName ="com.xt.bean";
	private static String daoPackageName ="com.xt.dao";
	private static String servicePackageName ="com.xt.service";
	private static String serviceImplPackageName ="com.xt.service"+smallBeanName+".impl";
	private static String webPackageName ="com.xt.web";
	
	//关于注释对应的相关的信息(相关注释的信息可以手动的进行修改)
	private static String author = "肖腾";//创建人
	private static String description ="后台角色管理";//模块对应的描述
	private static String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	
	
	public static String getRoot(String path){
		return new File(System.getProperty("user.dir"),path).getAbsolutePath();
	}
	
	//自动构建bean
	public static void createBean() throws IOException{
		//获取java   bean文件存放的根目录
		String rootPath = getRoot(srcPath+beanPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+".java");
		//获取模板页面路径
		String template = getRoot(beanTemplate);
		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Bean: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Bean: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+beanPackageName+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	/**
	 * (dao下面mapper接口的构建)
	 * com.xt.auto 
	 * 方法名：createDao
	 * 创建人：肖腾
	 * 时间：2016年1月11日-下午7:03:16 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createDao() throws IOException{
		//bean的根目录
		String rootPath = getRoot(srcPath+daoPath+smallBeanName);
//		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "I"+beanName+"Mapper.java");
		//获取模板页面路径
		String template = getRoot(daoTemplate);
//		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Mapper: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Mapper: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+daoPackageName+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	
	/**
	 * 
	 * (dao mybatis sql配置文件的自动构建)
	 * com.xt.auto 
	 * 方法名：createSQLXml
	 * 创建人：肖腾
	 * 时间：2016年1月11日-下午7:04:02 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createSQLXml() throws IOException{
		//bean的根目录
		String rootPath = getRoot(srcPath+daoPath+smallBeanName);
//		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+".xml");
		//获取模板页面路径
		String template = getRoot(xmlTemplate);
//		//读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示sqlxml: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示sqlxml: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+daoPackageName+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	       
	/**
	 * 
	 * (结果页面显示的构建)
	 * com.xt.auto 
	 * 方法名：createPage
	 * 创建人：肖腾
	 * 时间：2016年1月11日-下午7:05:57 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createPage() throws IOException {
		// bean的根目录
		String rootPath = getRoot(pagePath);
		// //自动创建根目录
		File rootFile = new File(rootPath);
		if (!rootFile.exists())
			rootFile.mkdirs();
		// 写入的目标文件
		File beanFile = new File(rootFile, "list.jsp");
		// 获取模板页面路径
		String template = getRoot(pageTemplate);
		// //读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		// 替换模板内容
		content = replaceTemplate(content);
		// 判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Pages: 】【" + beanFile.getAbsolutePath()
					+ "】已经存在，是否覆盖yes/no!\n");
			// 控制台输入对象
			Scanner scanner = new Scanner(System.in);
			// 获取控制台输入的值
			String mark = scanner.nextLine();
			if (mark.equalsIgnoreCase("yes")) {
				// 替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(),
						content, "UTF-8");
			}
		} else {
			System.out.println("【自动构建提示Pages: 】您当前创建的:【"
					+ beanFile.getAbsolutePath() + "】写入到【" + pagePath
					+ "】成功!!!");
			// 替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content,
					"UTF-8");
		}
	}
		
    
	/**
	 * 
	 * (web层的自动构建)
	 * com.xt.auto 
	 * 方法名：createWeb
	 * 创建人：肖腾
	 * 时间：2016年1月11日-下午7:07:11 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createWeb() throws IOException {
		// bean的根目录
		String rootPath = getRoot(srcPath + webPath);
		// //自动创建根目录
		File rootFile = new File(rootPath);
		if (!rootFile.exists())
			rootFile.mkdirs();
		// 写入的目标文件
		File beanFile = new File(rootFile, beanName + "Control.java");
		// 获取模板页面路径
		String template = getRoot(webTemplate);
		// //读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		// 替换模板内容
		content = replaceTemplate(content);
		// 判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Web: 】【" + beanFile.getAbsolutePath()
					+ "】已经存在，是否覆盖yes/no!\n");
			// 控制台输入对象
			Scanner scanner = new Scanner(System.in);
			// 获取控制台输入的值
			String mark = scanner.nextLine();
			if (mark.equalsIgnoreCase("yes")) {
				// 替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(),
						content, "UTF-8");
			}
		} else {
			System.out.println("【自动构建提示Web: 】您当前创建的:【"
					+ beanFile.getAbsolutePath() + "】写入到【" + webPackageName
					+ "】成功!!!");
			// 替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content,
					"UTF-8");
		}
	}
		
	/**
	 * 
	 * (服务层实现类的构建)
	 * com.xt.auto 
	 * 方法名：createServiceImpl
	 * 创建人：肖腾
	 * 时间：2016年1月11日-下午7:07:43 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createServiceImpl() throws IOException {
		// bean的根目录
		String rootPath = getRoot(srcPath + serviceImplPath);
		// //自动创建根目录
		File rootFile = new File(rootPath);
		if (!rootFile.exists())
			rootFile.mkdirs();
		// 写入的目标文件
		File beanFile = new File(rootFile, beanName + "ServiceImpl.java");
		// 获取模板页面路径
		String template = getRoot(serviceImplTemplate);
		// //读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		// 替换模板内容
		content = replaceTemplate(content);
		// 判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示ServiceImpl: 】【"
					+ beanFile.getAbsolutePath() + "】已经存在，是否覆盖yes/no!\n");
			// 控制台输入对象
			Scanner scanner = new Scanner(System.in);
			// 获取控制台输入的值
			String mark = scanner.nextLine();
			if (mark.equalsIgnoreCase("yes")) {
				// 替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(),
						content, "UTF-8");
			}
		} else {
			System.out.println("【自动构建提示ServiceImpl: 】您当前创建的:【"
					+ beanFile.getAbsolutePath() + "】写入到【"
					+ serviceImplPackageName + "】成功!!!");
			// 替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content,
					"UTF-8");
		}
	}
		
	/**
	 * 
	 * (服务层接口的构建)
	 * com.xt.auto 
	 * 方法名：createService
	 * 创建人：肖腾
	 * 时间：2016年1月11日-下午7:08:27 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createService() throws IOException {
		// bean的根目录
		String rootPath = getRoot(srcPath + servicePath + smallBeanName);
		// //自动创建根目录
		File rootFile = new File(rootPath);
		if (!rootFile.exists())
			rootFile.mkdirs();
		// 写入的目标文件
		File beanFile = new File(rootFile, "I" + beanName + "Service.java");
		// 获取模板页面路径
		String template = getRoot(serviceTemplate);
		// //读取模板内容
		String content = TmFileUtil.readFileByLines(template);
		// 替换模板内容
		content = replaceTemplate(content);
		// 判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Service: 】【"
					+ beanFile.getAbsolutePath() + "】已经存在，是否覆盖yes/no!\n");
			// 控制台输入对象
			Scanner scanner = new Scanner(System.in);
			// 获取控制台输入的值
			String mark = scanner.nextLine();
			if (mark.equalsIgnoreCase("yes")) {
				// 替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(),
						content, "UTF-8");
			}
		} else {
			System.out.println("【自动构建提示Service: 】您当前创建的:【"
					+ beanFile.getAbsolutePath() + "】写入到【" + servicePackageName
					+ "】成功!!!");
			// 替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content,
					"UTF-8");
		}
	}
	
	
	/**
	 * 
	 * (对模版的内容进行替换 返回对应的真正的bean文件的内容)
	 * com.xt.auto 
	 * 方法名：replaceTemplate
	 * 创建人：肖腾
	 * 时间：2016年1月11日-下午6:34:33 
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String replaceTemplate(String content) {
		if (TmStringUtils.isNotEmpty(content)) {
            content = content.replaceAll("\\[beanPackageName\\]", beanPackageName)
					.replaceAll("\\[daoPackageName\\]",daoPackageName)
					.replaceAll("\\[servicePackageName\\]",servicePackageName)
					.replaceAll("\\[webPackageName\\]",webPackageName)
            		.replaceAll("\\[author\\]",author)
            		.replaceAll("\\[date\\]", date)
            		.replaceAll("\\[beanName\\]", beanName)
            		.replaceAll("\\[description\\]", description)
            		.replaceAll("\\[smallBeanName\\]", smallBeanName);
			return content;
		} else {
			return "";
		}
	}
   
	/**
	 * (一键自动构建项目)
	 * com.xt.auto 
	 * 方法名：main
	 * 创建人：肖腾
	 * 时间：2016年1月11日-下午7:52:49 
	 * @param args
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) throws IOException {
		//自动构建bean的目录
		createBean();
		createDao();
		createSQLXml();
		createService();
		createServiceImpl();
		createWeb();
		createPage();
	}

}
