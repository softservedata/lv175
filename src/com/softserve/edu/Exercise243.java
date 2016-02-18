package com.softserve.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise243 {
	/*
	 * 243. ƒано натуральне число n. „и можна його представити
	 * 		у вигл€д≥ суми двох квадрат≥в натуральних чисел? 
	 * 		якщо можна, то:
	 * 		а) вказати пару х,у таких натуральних чисел, що n = x^2 + y^2
	 */
	
	public static void main(String[] args){
		System.out.print("Enter natural number: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int natural = 0;
		try {
			String val = br.readLine();
			natural = Integer.parseInt(val);
			if(natural < 1) throw new NumberFormatException();
			
			int sqrt = (int) Math.sqrt(natural - 1);		
			Pair pair = searchNx2y2(natural,sqrt,1);
			if(pair.x==0 || pair.y==0){
				System.out.println("No matches found!");
			}else{
				System.out.println("Found ["+pair.x+","+pair.y+"]: "+natural+" = "+pair.x+"^2 + "+pair.y+"^2");
			}

			
		} catch(NumberFormatException e){
			System.out.println("Error: Incorrect number format! Use natural numbers! (1,2,3,4,...)");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Search for x and y that match n = x^2 + y^2
	 * @param n natural value
	 * @param x init value must be the maximum possible value 
	 * @param y init value must be 1!
	 * @return Pair.XY if xy=00 there a miss else match
	 */
	private static Pair searchNx2y2(int n,int x,int y){
		Pair res;
		if(x<1) return new Pair(0,0);//not natural
		
		int sum = (int) (Math.pow(x, 2)+Math.pow(y, 2));
		if( sum == n ){ //We found successful pair
			return new Pair(x,y);
		}else if(sum>n){ //Missed with X
			res = searchNx2y2(n, x-1,y);
		}else{	//Missed with Y
			res = searchNx2y2(n, x,y+1);
		}
		return res;
	}
	
	
	private static class Pair{
		Pair(int x, int y){
			this.x=x;
			this.y = y;
		}
		int x,y;
	}
}
