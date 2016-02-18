package com.softserv.anpavlo;

public class Dividers {
	
	public static void getDividers(Integer n){
		int i = 1;
		System.out.println("Dividers of "+n);
		while (i<=n/2){//ділимо на 2 оскільки найбільший дільник крім самого числа є його половина
			if (n%i==0){
				System.out.println(i);
			}
			i++;
		}
		System.out.println(n);
	}

}
