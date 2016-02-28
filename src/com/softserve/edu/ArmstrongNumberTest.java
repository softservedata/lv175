package com.yrymash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArmstrongNumberTest {

	public static boolean isArmstrongNumber(int number) {
		int result = 0;
		int count = (int)Math.ceil(Math.log10(number));
		int orig = number;
		while(number != 0){
			int remainder = number%10;
			result = result + (int) Math.pow(remainder, count);
			number = number/10;
			}
		if(orig == result){
			return true;
			}
		return false;
		} 
	
	public static void main(String[] args) {
		List<Integer> listArmstrong = new ArrayList<Integer> ();
		for(int i = 10; i < 10000; i++){
			int number = i;
				if(isArmstrongNumber(number) == true){
					listArmstrong.add(number);
					}
				}
			
			
		Iterator<Integer> iter = listArmstrong.iterator();
			while(iter.hasNext()){
				Integer armstrongNum = iter.next();
				System.out.println(armstrongNum);
		}
	}
}

