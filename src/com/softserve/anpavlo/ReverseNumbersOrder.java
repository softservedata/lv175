package com.softserv.anpavlo;

public class ReverseNumbersOrder {
	
	public static String getNumbersInReverseOrder(Integer n){//123456789
		System.out.println("ReverseNumbersOrder of "+n);
		
		int reverse = n%10;
		String result = ""+reverse;
		while (n>=10){
			n = n/10;
			result = result+(n%10);
			//reverse = reverse*10+n%10;
		}
		//System.out.println("reverse = "+reverse);
		return result;	
		
		
	}

}
