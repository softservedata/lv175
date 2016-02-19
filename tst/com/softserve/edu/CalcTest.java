package com.softserve.edu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		// System Under test
		Calc calc = new Calc();
		double expected = 5;
		double actual;
		actual = calc.add(2.0, 3);
		Assert.assertEquals(expected, actual, 0.000001);
		// fail("Not yet implemented");
	}

	@Test
	public void testDiv() {
		System.out.println("testDiv()");
		// System Under test
		Calc calc = new Calc();
		double expected = 1.5;
		double actual;
		actual = calc.div(3, 2);
		System.out.println("actual = " + actual);
		Assert.assertEquals(expected, actual, 0.000001);
	}

	@Test
	public void testHello() {
		System.out.println("testHello()");
		Calc calc = new Calc();
		String expected = "Hello Ivan";
		String actual;
		actual = calc.hello("Ivan");
		Assert.assertEquals(expected, actual);
		//
		// throw new RuntimeException("hA-hA-hA");
	}

}
