package com.softserve.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise88 {
	/*
	 * 88. 	Дано натуральне число n.
	 * 		г) Дописати по одиниці напочатку і в кінці запису числа
	 */

	public static void main(String[] args) {
		System.out.print("Enter natural number: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int natural = 0;
		try {
			String val = br.readLine();
			natural = Integer.parseInt(val);
			if(natural < 1) throw new NumberFormatException();
			
			int digits = (int) Math.log10(natural);
			natural += Math.pow(10,  digits+1);
			natural = natural*10+1;
			System.out.println("Result: "+natural);
		} catch(NumberFormatException e){
			System.out.println("Error: Incorrect number format! Use natural numbers!");
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
