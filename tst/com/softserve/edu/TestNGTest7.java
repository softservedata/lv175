package com.softserve.edu;

import java.util.Vector;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest7 {

	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() {
		return new Object[][] {
				{ Vector.class,
					new String[] { "java.util.AbstractList", "java.util.AbstractCollection" } },
				{ String.class,
						new String[] { "1", "2" } },
				{ Integer.class,
							new String[] { "3", "4", "5" }  },
			};
	}

	@Test(dataProvider = "Data-Provider-Function")
	public void parameterIntTest(Class<?> clzz, String[] number) {
		System.out.println("\nClass clzz = " + clzz.getName());
		for (String num : number) {
			System.out.println("Parameterized Number is: " + num);
		}
	}

}
