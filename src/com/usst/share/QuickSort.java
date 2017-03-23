package com.usst.share;

import java.util.Scanner;

//快速排序
public class QuickSort {
	public QuickSort(){}
	public static int[] quickSort(int[] target, int start, int end){
		if(start > end){
			return target;
		}else{	
			//排序--分治思路
			int partition = partition(target, start, end);
			quickSort(target, start, partition-1);
			quickSort(target, partition+1, end);
		}
		return target;
	}
	//确定一个切割元素的位置
	public static int partition(int[] target, int start, int end){
		int key = target[start];
		while(start < end){
			while(target[end] >= key && end >start){
				end--;
			}
			target[start] = target[end];
			while(target[start] <= key && start < end){
				start++;
			}
			target[end] = target[start];
		}
		target[start] = key;
		return start;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			String[] target = in.nextLine().split(" ");//第一行：输入一个无序数组
			String[] s = in.nextLine().split(" ");//第二行：输入排序的始末位置，以空格隔开
			int[] tar = new int[target.length];
			for(int i=0; i<target.length; i++){
				tar[i] = Integer.parseInt(target[i]);
			}
			int[] tar2 = new int[2];
			for(int i=0; i<s.length; i++){
				tar2[i] = Integer.parseInt(s[i]);
			}
			if(tar2[0] == tar2[1]){
				System.out.println("排序目标始末位置不能相等，请修改！");
			}
			if(tar2[0]<0 || tar2[1]>tar.length-1){
				System.out.println("排序目标起始或末尾位置越界，请修改！");
			}
			if(tar2[0] > tar2[1]){
				System.out.println("排序目标始末位置不符合规则，请修改！");
			}
			int[] sort = quickSort(tar, tar2[0], tar2[1]);//排序
			String result = "";
			for(int m : sort){
				result += m + " "; 
			}
			System.out.println(result);//输出排序结果
		} finally {
			in.close();
		}
	}
}
