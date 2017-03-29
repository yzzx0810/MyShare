package com.usst.share;

import java.util.Scanner;

/*0-1背包问题*/

public class DPTest2 {
	static int[][] bags = {{0,0}, {2,6}, {2,3}, {6,5}, {5,4}, {4,6}};
	
	public static int maxValue(int bagWeight){
		int[][] bagMaxValue = new int[bags.length][bagWeight+1];
		for(int i=1; i<bagWeight+1; i++){
			for(int j=1; j<bags.length; j++){
				if(bags[j][0]<=i && 
						bagMaxValue[j-1][i]<bagMaxValue[j-1][i-bags[j][0]]+bags[j][1]){
					bagMaxValue[j][i] = bagMaxValue[j-1][i-bags[j][0]]+bags[j][1];
				}else{
					bagMaxValue[j][i] = bagMaxValue[j-1][i];
				}
			}
		}
		return bagMaxValue[bagMaxValue.length-1][bagMaxValue[bagMaxValue.length-1].length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		try {
			int bagWeight = in.nextInt();
			int maxValue = maxValue(bagWeight);
			System.out.println(maxValue);
		} finally {
			in.close();
		}
	}

}
