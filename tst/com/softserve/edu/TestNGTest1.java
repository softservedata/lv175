package com.softserve.edu;

import java.util.ArrayList;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest1 {
	private Collection<String> collection;

	@BeforeClass(groups = "method1")
	public void oneTimeSetUp() {
		System.out.println("@BeforeClass - oneTimeSetUp");
	}

	@AfterClass(groups = "method1")
	public void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
	}

	@BeforeMethod(groups = "method1")
	public void setUp() {
		collection = new ArrayList<String>();
		System.out.println("@BeforeMethod - setUp");
	}

	@AfterMethod(groups = "method1")
	public void tearDown() {
		collection.clear();
		System.out.println("@AfterMethod - tearDown");
	}

	@Test(groups = "method1")
	public void testEmptyCollection() {
		System.out.println("@Test - testEmptyCollection");
		Assert.assertEquals(collection.isEmpty(), true);
	}

	@Test
	public void testOneItemCollection() {
		collection.add("itemA");
		Assert.assertEquals(collection.size(), 1);
		System.out.println("@Test - testOneItemCollection");
	}
}
