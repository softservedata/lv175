package com.softserve.edu.data;

import java.util.ArrayList;
import java.util.List;

public final class DataRepository {

	private DataRepository() {
	}

	public static List<Integer> getData() {
		List<Integer> result = new ArrayList<Integer>();
		result.add(11);
		result.add(12);
		return result;
	}

}
