package com.yrymash;

import java.util.Scanner;

public class SumLastNumberTest {

	
	private static Integer getSumOfLastNumbers(Integer n, Integer m){
		Integer result = 0;
		n = Math.abs(n);
		
		if(Math.log10(n)+1 >= m){
			while(n  > 0 && m > 0){
				Integer numFromN = n%10;
				result += numFromN;
				n = n/10;
				m = m - 1;
				}
		}
		return result;
		}
	
	public static void main(String[] args) {
		
		System.out.println("Please enter number and count of its last numeric");
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		if((int)Math.ceil(Math.log10(a))>= b){
			int result = getSumOfLastNumbers(a, b);
			System.out.println("The sum of " + b + " last numeric of number " + a + " = " + result);
		} else{
			System.out.println("Incorrect count of numerics");
		}
	}

}
