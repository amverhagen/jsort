package main;

import java.util.Arrays;

import sorters.Quick;

public class QuickTester {

	public static void main(String args[]) {
		int[] testArray = { 99, 20, 33, 2, 22, 33, 9 };
		testArray = Quick.getSortedList(testArray);
		System.out.println(Arrays.toString(testArray));
	}
}
