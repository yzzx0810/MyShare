package com.usst.share;

import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		try {
			String[] strings1 = in.nextLine().split(" ");
			String[] strings2 = in.nextLine().split(" ");
			for(int i=0; i< Integer.parseInt(strings1[1]); i++){
				String s = strings2[0];
				for(int j=0; j<strings2.length; j++){
					if(j < strings2.length-1){
						strings2[j] = String.valueOf(Integer.parseInt(strings2[j])
										+ Integer.parseInt(strings2[j+1]));	
					}else{
						strings2[j] = String.valueOf(Integer.parseInt(strings2[j])
								+ Integer.parseInt(s));	
					}
				}
			}
			String result = "";
			for(int i=0; i<strings2.length; i++){
				result += strings2[i] + " ";
			}
			System.out.println(result.substring(0, result.length()-1));
		} finally {
			in.close();
		}
	}
}
