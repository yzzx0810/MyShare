/*题目描述
老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 
输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

输出描述:
对于每一次询问操作，在一行里面输出最高成绩.

输入例子:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出例子:
5
6
5
9*/
package com.usst.share;

import java.util.*;

public class D {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		try {
			String l1 = in.nextLine();//第一行（N M）
			String l2 = in.nextLine();//第二行
			String[] score = l2.split(" ");//成绩数组--N个
			int height = Integer.parseInt(l1.split(" ")[1]);
			ArrayList<String> operList = new ArrayList<>();
			//根据M值，确定输入操作个数
			for(int i = 0; i < height; i++){
				operList.add(in.nextLine());
			}
			//依次执行各操作
			for(int i =0; i < operList.size(); i++){
				String[] oper = operList.get(i).split(" ");
				switch (oper[0]) {
				case "Q":
					String[] result = new String[Integer.parseInt(oper[2])-Integer.parseInt(oper[1])+1];
					int start = Integer.parseInt(oper[1]);
					int end = Integer.parseInt(oper[2]);
					//查询起始，末尾均不能越界
					if( start>0 && end<=Integer.parseInt(l1.split(" ")[0]) && start<=end){
						int n = 0;
						for(int m = start-1; m<end; m++){
							result[n++] = score[m];
						}
						//一次冒泡排序，最小值移动到最后一位
						for(int k=0; k<result.length-1; k++){
							if(Integer.parseInt(result[k])< Integer.parseInt(result[k+1])){
								String str = result[k];
								result[k] = result[k+1];
								result[k+1] = str;
							}
						}
						System.out.println("此时最小值为：" + result[result.length-1]);
					}else{
						System.out.println("查询失败");
					}
					break;
				case "U":
					int obj = Integer.parseInt(oper[1]);
					//更新地址不能越界
					if(obj>0 && obj<=Integer.parseInt(l1.split(" ")[0])){
						score[obj-1] = oper[2];
					}else{
						System.out.println("更新对象不存在，更新失败");
					}
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			
		}finally {
			//显示关闭输入流
			in.close();
		}
	}
}
