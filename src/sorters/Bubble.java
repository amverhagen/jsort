package sorters;

import java.util.ArrayList;
import java.util.Arrays;

public class Bubble {

	public static int[] getSortedList(int[] unsorted) {
		int[] sorted = unsorted;
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
		ArrayList<String> sorted = new ArrayList<String>();
		for (int i = unsorted.length; i > 0; i--) {
			for (int j = 0; j < (i - 1); j++) {
				if (unsorted[j] > unsorted[j + 1]) {
					int temp = unsorted[j];
					unsorted[j] = unsorted[j + 1];
					unsorted[j + 1] = temp;
					sorted.add("Swapped " + temp + " and " + unsorted[j]);
					sorted.add(Arrays.toString(unsorted));
				}
			}
		}
		return sorted;
	}
}
