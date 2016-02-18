package com.softserve.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise561 {
	/*
	 * 261. Дано натуральне число n. Серед чисел 1,..., n знайти
	 * 		всі такі, запис яких співпадає з останніми цифрами
	 * 		запису їх квадрата (приклад: 6^2 = 36, 25^2 = 625)
	 */

	public static void main(String[] args) {
		System.out.print("Enter natural number: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int natural = 0;
		try {
			String val = br.readLine();
			natural = Integer.parseInt(val);
			if(natural < 1) throw new NumberFormatException();
			
			for(int i=1;i<=natural;i++){
				int digits = (int) Math.log10(i) +1;
				int pow = (int) Math.pow(i, 2);		
				if( (pow-i) % (Math.pow(10, digits)) == 0){
					System.out.println(i+"^2 = "+pow);
				}
			}
			
		} catch(NumberFormatException e){
			System.out.println("Error: Incorrect number format! Use natural numbers!");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
