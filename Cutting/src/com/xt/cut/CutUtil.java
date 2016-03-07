package com.xt.cut;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * 用java的头像工具类进行裁剪
 * 
 * @author 肖腾
 * 
 */
public class CutUtil {

	/**
	 * @param srcpath
	 *            原图片的路径
	 * @param targetPath
	 *            截取图片存放的路径
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @param width
	 *            裁剪图片的宽度
	 * @param height
	 *            裁剪图片的高度
	 */
	// 裁剪图片的方法
	public static void cutImg(String srcPath, String targetPath, int x, int y,
			int width, int height) {
		FileInputStream fileInputStream = null;
		ImageInputStream imageInputStream = null;
		try {
			// 建立文件的输入流
		    fileInputStream = new FileInputStream(srcPath);
			//获取图片流体，建立图片文件的输入流向(将文件输入流转化为图片输入流)
			imageInputStream = ImageIO.createImageInputStream(fileInputStream);
			
			// 识别什么格式的图片
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName("jpg");
			ImageReader ir = it.next();
			
			ir.setInput(imageInputStream, true);
			
			//读取图片的参数对象
			ImageReadParam param = ir.getDefaultReadParam();
			// 定义裁剪区域(Rectangle awt关于裁剪的类)（将用户裁剪的参数设置到对应的图片的读取参数对象中去）
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);

			// 将截取的图像存放在缓冲区
			BufferedImage bi = ir.read(0, param);

			// 保存对应的图片
			ImageIO.write(bi, "jpg", new File(targetPath));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("图片的裁剪失败");
		}finally{
			//关闭文件的输入流
			try{
			if(fileInputStream!=null){
					fileInputStream.close();
			}
			if(imageInputStream!=null){
				imageInputStream.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
