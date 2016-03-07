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
 * ��java��ͷ�񹤾�����вü�
 * 
 * @author Ф��
 * 
 */
public class CutUtil {

	/**
	 * @param srcpath
	 *            ԭͼƬ��·��
	 * @param targetPath
	 *            ��ȡͼƬ��ŵ�·��
	 * @param x
	 *            x����
	 * @param y
	 *            y����
	 * @param width
	 *            �ü�ͼƬ�Ŀ��
	 * @param height
	 *            �ü�ͼƬ�ĸ߶�
	 */
	// �ü�ͼƬ�ķ���
	public static void cutImg(String srcPath, String targetPath, int x, int y,
			int width, int height) {
		FileInputStream fileInputStream = null;
		ImageInputStream imageInputStream = null;
		try {
			// �����ļ���������
		    fileInputStream = new FileInputStream(srcPath);
			//��ȡͼƬ���壬����ͼƬ�ļ�����������(���ļ�������ת��ΪͼƬ������)
			imageInputStream = ImageIO.createImageInputStream(fileInputStream);
			
			// ʶ��ʲô��ʽ��ͼƬ
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName("jpg");
			ImageReader ir = it.next();
			
			ir.setInput(imageInputStream, true);
			
			//��ȡͼƬ�Ĳ�������
			ImageReadParam param = ir.getDefaultReadParam();
			// ����ü�����(Rectangle awt���ڲü�����)�����û��ü��Ĳ������õ���Ӧ��ͼƬ�Ķ�ȡ����������ȥ��
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);

			// ����ȡ��ͼ�����ڻ�����
			BufferedImage bi = ir.read(0, param);

			// �����Ӧ��ͼƬ
			ImageIO.write(bi, "jpg", new File(targetPath));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ͼƬ�Ĳü�ʧ��");
		}finally{
			//�ر��ļ���������
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
