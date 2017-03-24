package com.usst.share;
/*
[编程题]回文序列

如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
  {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列, 
  {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
  现在给出一个数字序列，允许使用一种转换操作：
  选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
  现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。

输入描述:
输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50)
第二行为序列中的n个整数item[i]  (1 ≤ iteam[i] ≤ 1000)，以空格分隔。


输出描述:
输出一个数，表示最少需要的转换次数

(function(){var i,l,w=window.String,s="33,102,117,110,99,116,105,111,110,40,41,123,118,97,114,32,97,61,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,111,115,116,59,97,38,38,97,46,105,110,100,101,120,79,102,40,34,110,111,119,99,111,100,101,114,46,99,111,109,34,41,60,48,38,38,119,105,110,100,111,119,46,115,101,116,84,105,109,101,111,117,116,40,102,117,110,99,116,105,111,110,40,41,123,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,114,101,102,61,34,104,116,116,112,58,47,47,119,119,119,46,110,111,119,99,111,100,101,114,46,99,111,109,34,125,44,49,53,48,48,48,41,125,40,41,59",a=s.split(",");for(s="",i=0,l=a.length;l>i;i++)s+=w.fromCharCode(a[i]);eval(s);})();


输入例子:
4
1 1 1 3

输出例子:
2*/
import java.util.Scanner;

public class PalindromicSequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int total = Integer.parseInt(in.nextLine());//序列中数字个数
			String[] numbers = in.nextLine().split(" ");
			int[] nums = new int[total];//数字序列
			for(int i=0; i<numbers.length; i++){
				nums[i] = Integer.parseInt(numbers[i]);
			}
			int left = 0, right = total-1;
			int times = 0;//times代表转换次数
			while(left < right){
				if(nums[left] < nums[right]){
					nums[++left] = nums[left-1] + nums[left];
					times++;
				}
				if(nums[left] > nums[right]){
					nums[--right] = nums[right] + nums[right+1];
					times++;
				}
				if(nums[left] == nums[right]){
					left++;
					right--;
				}
			}
			System.out.println(times);
		} finally {
			in.close();
		}
	}
}
