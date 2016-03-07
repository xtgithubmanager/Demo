package com.xt.cut;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
       int [] a = new int[10];
       Scanner s = new Scanner(System.in);
       System.out.println("开始输入数字------");
       for(int i =0; i<a.length; i++){
    	   System.out.println("请输入输入第"+(i+1)+"个数字：");
    	   a[i] = s.nextInt();
       }
       //输出未交换数组的值
       System.out.println("交换前的数组：");
       for(int i = 0; i<a.length; i++){
    	   System.out.print(a[i]+"  ");
       }
	   int b;
	   System.out.println("");
       //开始执行行交换的操作
	   System.out.println("交换后的数组：");
       for(int i =0; i<(a.length)/2; i++){
    	   b = a[i];
    	   a[i]=a[9-i];
    	   a[9-i] =b;
       }
       //输出交换后的数字
       for(int i = 0; i<a.length; i++){
    	   System.out.print(a[i]+"  ");
       }
	}
}
