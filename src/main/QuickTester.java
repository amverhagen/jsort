package main;

import java.util.Arrays;

import sorters.Quick;
import tools.ArrayTools;

public class QuickTester {

	public static void main(String args[]) {
		for (int i = 0; i < 15; i++) {
			int[] testArray = ArrayTools.getRandomIntArray(i);
			testArray = Quick.getSortedList(testArray);
			System.out.println("final " + Arrays.toString(testArray));
		}

	}
}
