package com.softserve.edu;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest5 {

	@BeforeClass(groups = {"method2", "method1", "method4"})
	public void oneTimeSetUp() {
		System.out.println("*****@BeforeClass - oneTimeSetUp");
	}

	@BeforeMethod(groups = {"method2", "method1", "method4"})
	public void setUp() {
		System.out.println("+++++@BeforeMethod - setUp");
	}

	@AfterMethod(groups = {"method2", "method1", "method4"})
	public void tearDown() {
		System.out.println("-----@AfterMethod - tearDown");
	}

	@Test(groups = "method1")
	public void testingMethod1() {
		System.out.println("Method - testingMethod1( )");
	}

	@Test(groups = {"method2", "method1"})
	public void testingMethod2() {
		System.out.println("Method - testingMethod2( )");
	}

	@Test(groups = "method1")
	public void testingMethod1_1() {
		System.out.println("Method - testingMethod1_1( )");
	}

	@Test(groups = "method4")
	public void testingMethod4() {
		System.out.println("Method - testingMethod4( )");
	}
}
