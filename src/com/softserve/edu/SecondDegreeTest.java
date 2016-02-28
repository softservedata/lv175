package com.yrymash;

import java.util.Scanner;

public class SecondDegreeTest {

	
	public static void main(String[] args) {
		
		System.out.println("Please enter a number");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int x;
		int y;
		if(num%4 == 1){
			for(x = 0; x < num; x++){
				for(y = 0; y < num; y++){
					if(Math.pow(x, 2) + Math.pow(y, 2) == num && x >= y){
						System.out.println(x*x + " + " + y*y + " = " + num);
						}
					}
				}
			}else{
				System.out.println("This number can not be decomposed into the sum of two numbers of the second degree");
			}
	
		}
	
}


