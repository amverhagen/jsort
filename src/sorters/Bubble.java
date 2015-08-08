package sorters;

import java.util.ArrayList;
import java.util.Arrays;

public class Bubble {

	public static int[] getSortedList(int[] unsorted) {
		int[] sorted = unsorted.clone();
		for (int i = sorted.length; i > 0; i--) {
			for (int j = 0; j < (i - 1); j++) {
				if (sorted[j] > sorted[j + 1]) {
					int temp = sorted[j];
					sorted[j] = sorted[j + 1];
					sorted[j + 1] = temp;
				}
			}
		}
		return sorted;
	}

	public static ArrayList<String> getSortedStepList(int[] unsorted) {
		int[] original = unsorted.clone();
		ArrayList<String> sorted = new ArrayList<String>();
		for (int i = original.length; i > 0; i--) {
			for (int j = 0; j < (i - 1); j++) {
				if (original[j] > original[j + 1]) {
					int temp = original[j];
					original[j] = original[j + 1];
					original[j + 1] = temp;
					sorted.add("Swapped " + temp + " and " + original[j]);
					sorted.add(Arrays.toString(original));
				}
			}
		}
		return sorted;
	}
}
