package com.usst.share;
/*
[编程题]优雅的点

小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 例如：半径的平方如果为25
 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。

输入描述:
输入为一个整数，即为圆半径的平方,范围在32位int范围内。


输出描述:
输出为一个整数，即为优雅的点的个数

(function(){var i,l,w=window.String,s="33,102,117,110,99,116,105,111,110,40,41,123,118,97,114,32,97,61,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,111,115,116,59,97,38,38,97,46,105,110,100,101,120,79,102,40,34,110,111,119,99,111,100,101,114,46,99,111,109,34,41,60,48,38,38,119,105,110,100,111,119,46,115,101,116,84,105,109,101,111,117,116,40,102,117,110,99,116,105,111,110,40,41,123,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,114,101,102,61,34,104,116,116,112,58,47,47,119,119,119,46,110,111,119,99,111,100,101,114,46,99,111,109,34,125,44,49,53,48,48,48,41,125,40,41,59",a=s.split(",");for(s="",i=0,l=a.length;l>i;i++)s+=w.fromCharCode(a[i]);eval(s);})();


输入例子:
25

输出例子:
12*/
import java.util.Scanner;

public class ElegantPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		try {
			String input = in.nextLine();//输入的参数
			int radius = (int) Math.sqrt(Integer.parseInt(input));
			while(Math.pow(radius, 2) < Double.parseDouble(input)){
				System.out.println("参数不符合要求，请重新输入！");
				input = in.nextLine();
				radius = (int) Math.sqrt(Integer.parseInt(input));
			}
			int result = 0;//result代表优雅的点个数
			for(int i=(0-radius); i<=radius; i++){
				int r = radius*radius - i*i;
				int rr = (int) Math.sqrt(r);
				if(rr*rr == r){
					result += 2;
				}
			}
			result = result -2;//左顶点、右顶点只有一个
			System.out.println(result);
		} finally {
			in.close();
		}
	}
}
