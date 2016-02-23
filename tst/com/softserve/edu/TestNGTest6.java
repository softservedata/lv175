package com.softserve.edu;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTest6 {

	@Test
	@Parameters(value = "number")
	public void parameterIntTest(int number) {
		System.out.println("Parameterized Number is: " + number);
	}

	@Test
	@Parameters(value = "testurl")
	public void parameterIntTest2(String testurl) {
		System.out.println("Parameterized Number is: " + testurl);
	}

}
