package com.softserve.edu;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest4 {
	private long ms;

	@BeforeMethod
	public void setUp() {
		ms = System.currentTimeMillis();
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Time = " + (System.currentTimeMillis() - ms));
	}

	@Test(timeOut = 2000)
	public void infinity() {
		while (true)
			;
	}

}
