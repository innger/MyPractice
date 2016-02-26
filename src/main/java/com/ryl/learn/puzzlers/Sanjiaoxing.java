package com.ryl.learn.puzzlers;

import java.util.Arrays;
import java.util.Scanner;

public class Sanjiaoxing {
	
	private double[] a = new double[3];
	
	//返回排序的三边
	private double[] getTreeLine(){
		int i = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("输入三角形三边：");
		while(sc.hasNextDouble()){
			a[i++] = sc.nextDouble();
			if(i == 3){
				break;
			}
		}
		Arrays.sort(a);
		return a;
	}
	
	private double calculate(double[] a){
		double p = (a[0]+a[1]+a[2])/2;
		return Math.sqrt(p*(p-a[0])*(p-a[1])*(p-a[2]));
	}
	
	
	public static void main(String[] args) {
		Sanjiaoxing sjx = new Sanjiaoxing();
		double[] line = sjx.getTreeLine();
		//判断三角形三边的合法行
		while(!((line[0]+line[1] > line[2])&&(line[2]-line[1] < line[0])
				&&(line[2]-line[0] <line[1]))){
			System.out.println("输入三边错误！");
			line = sjx.getTreeLine();
		}
		System.out.println("三角形面积："+sjx.calculate(line));
	}

}
