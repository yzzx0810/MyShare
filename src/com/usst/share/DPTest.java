package com.usst.share;
/*如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 * --动态规划求解*/
import java.util.Scanner;

public class DPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		try {
			String number = in.nextLine();
			int[] coins = {1, 3, 5};
			//dp[i]代表组成数字i最少需要的数字组合
			int[] dp = new int[Integer.parseInt(number)+1];
			for(int i=0; i<dp.length; i++){
				dp[i] = i;
			}
			for(int i=1; i<dp.length; i++){
				for(int j=0; j<coins.length; j++){
					if(coins[j]<=i && dp[i-coins[j]]+1<dp[i]){
						dp[i] = dp[i-coins[j]]+1;
					}
				}
			}
			System.out.println("数字" + number + "最少需要" + dp[dp.length-1] + "个数字组合");
		} finally {
			// TODO: handle finally clause
			in.close();
		}
	}
}
