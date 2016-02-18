package com.softserv.anpavlo;

public class MercenNumbers {
	
	public static void printMercenNumbers(Integer n){
		System.out.println("MercenNumbers less "+n);
		
		int i = 1;
		int merNumber = (int) Math.pow(2, i)-1;
		while(merNumber<n){
			System.out.println(merNumber);
			i++;
			merNumber =  (int) Math.pow(2, i)-1;
		}
	} 

}
