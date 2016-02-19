package com.softserve.edu;

public class Appl {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//
		Calc calc = new Calc();
		System.out.println("1 + 2 = " + calc.add(1, 2));
		System.out.println("4 / 2 = " + calc.div(4, 2));
		System.out.println("Info: " + calc.hello("Ivan"));
		//
		double d = 1.0 / 0.0;
		System.out.println("double 1 / 0 = " + d);
		int i = 1 / 0;
		//System.out.println("int 1 / 0 = " + i);
	}

}
