package com.softserve.edu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest9 {

	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() {
		TestData obj = new TestData();
		obj.setMsg("Hello");
		obj.setNumber(123);
		TestData obj2 = new TestData();
		obj2.setMsg("Ha-ha-ha");
		obj2.setNumber(5678);
		return new Object[][] { { obj }, { obj2 }, };
	}

	@Test(dataProvider = "Data-Provider-Function")
	public void parameterIntTest(TestData data) {
		System.out.println("\nNumber is: " + data.getNumber());
		System.out.println("Message is: " + data.getMsg());
	}

}
