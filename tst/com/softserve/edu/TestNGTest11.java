package com.softserve.edu;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.data.DataRepository;

public class TestNGTest11 {

	@DataProvider
	public Object[][] validDataProvider(ITestContext context) {
		int i;
		//
		if (context.getCurrentXmlTest().getSuite().getParameter("number0") != null) {
			System.out.println("number0= " + context.getCurrentXmlTest().getSuite().getParameter("number0"));
		}
		if (context.getCurrentXmlTest().getSuite().getParameter("number1") != null) {
			System.out.println("number1= " + context.getCurrentXmlTest().getSuite().getParameter("number1"));
		}
		HashMap<String, String> hashMapSuite = new HashMap<String, String>(
				context.getCurrentXmlTest().getSuite().getParameters());
		//
		HashMap<String, String> hashMapTest = new HashMap<String, String>(
				context.getCurrentXmlTest().getTestParameters());
		//
		Object[][] provider = new Object[DataRepository.getData().size() 
		         + hashMapSuite.size() + hashMapTest.size()][1];
		//
		i = 0;
		for (String key : hashMapSuite.keySet()) {
			provider[i][0] = Integer.valueOf(hashMapSuite.get(key));
			i++;
			System.out.println("Suite key = " + key + "  value = " + hashMapSuite.get(key));
		}
		//i = hashMapSuite.size();
		for (String key : hashMapTest.keySet()) {
			provider[i][0] = Integer.valueOf(hashMapTest.get(key));
			i++;
			System.out.println("Suite key = " + key + "  value = " + hashMapTest.get(key));
		}
		//
		for (Integer num : DataRepository.getData()) {
			provider[i][0] = num;
			i++;
		}
//		for (i = 0; i < DataRepository.getData().size(); i++) {
//			provider[i + hashMapSuite.size() + hashMapTest.size()][0]
//					= DataRepository.getData().get(i);
//		}
		return provider;
		// return new Object[][] { { 65 }, { 97 }, };
	}

	@Test(dataProvider = "validDataProvider")
	public void contextTest(int number) {
		System.out.println("number= " + number);
	}

}
