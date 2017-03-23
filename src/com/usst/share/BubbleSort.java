package com.usst.share;

import java.util.Scanner;

//ц╟ещеепР
public class BubbleSort {
	public BubbleSort(){}
	public static int[] bubbleSort(int[] num){
		for(int i=0; i<num.length; i++){
			for(int j=num.length-1; j>i; j--){
				if(num[j]<num[j-1]){
					int mid = 0;
					mid = num[j];
					num[j] = num[j-1];
					num[j-1] = mid;
				}
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			String[] target = in.nextLine().split(" ");
			int[] tar = new int[target.length];
			for(int i=0; i<target.length; i++){
				tar[i] = Integer.parseInt(target[i]);
			}
			int[] sort = bubbleSort(tar);
			String result = "";
			for(int m : sort){
				result += m + " "; 
			}
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			in.close();
		}
	}
}
