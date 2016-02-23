package com.softserve.edu;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConcurrencyTest1 {
	private Map<String, String> data;
	private volatile int i = 0;

	@BeforeClass
	void setUp() throws Exception {
		data = new HashMap<String, String>();
	}

	@AfterClass
	void tearDown() throws Exception {
		data = null;
	}

	//@Test(threadPoolSize = 3, invocationCount = 5, invocationTimeOut = 10000)
	public void testMapOperations() throws Exception {
		data.put("1-"+String.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
		data.put("2-"+String.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
		data.put("3-"+String.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
		data.put("4-"+String.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
		data.put("5-"+String.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
		data.put("6-"+String.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
		data.put("7-"+String.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
		for (Map.Entry<String, String> entry : data.entrySet()) {
			System.out.println(entry);
		}
		data.clear();
	}
	
	//@Test(singleThreaded = true, // run in a single thread
	@Test(threadPoolSize = 3,
			invocationCount = 10, invocationTimeOut = 10000)
	public void testMapOperationsSafe() throws Exception {
		//i=i+1;
		data.put(String.valueOf(i++), "111");
		// data.put("1", "111");
		// data.put("2", "111");
		// data.put("3", "111");
		// data.put("4", "111");
		// data.put("5", "111");
		// data.put("6", "111");
		// data.put("7", "111");
		for (Map.Entry<String, String> entry : data.entrySet()) {
			System.out.println(entry);
		}
		data.clear();
	}

}