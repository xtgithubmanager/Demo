package com.xt.cut;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
       int [] a = new int[10];
       Scanner s = new Scanner(System.in);
       System.out.println("��ʼ��������------");
       for(int i =0; i<a.length; i++){
    	   System.out.println("�����������"+(i+1)+"�����֣�");
    	   a[i] = s.nextInt();
       }
       //���δ���������ֵ
       System.out.println("����ǰ�����飺");
       for(int i = 0; i<a.length; i++){
    	   System.out.print(a[i]+"  ");
       }
	   int b;
	   System.out.println("");
       //��ʼִ���н����Ĳ���
	   System.out.println("����������飺");
       for(int i =0; i<(a.length)/2; i++){
    	   b = a[i];
    	   a[i]=a[9-i];
    	   a[9-i] =b;
       }
       //��������������
       for(int i = 0; i<a.length; i++){
    	   System.out.print(a[i]+"  ");
       }
	}
}
