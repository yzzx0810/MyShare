package com.usst.share;

public class A {
	public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1){
        	return originStr;
        }
	    return reverse(originStr.substring(1)) + originStr.charAt(0);
	}
	 
	public static void main(String[] args) {
		Counter a = new Counter();
        System.out.println(a.increment());
        System.out.println(a.anotherIncrement());
        Counter b = new Counter();
        System.out.println(b.increment());
	}
}

class Counter
{
    private static int count = 0;
    public int increment()
    {
        return count++;
    }
    public int anotherIncrement()
    {
        return ++count;
    }
}
