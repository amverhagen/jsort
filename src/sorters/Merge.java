package sorters;

import java.util.ArrayList;
import java.util.Arrays;

import tools.ArrayTools;

public class Merge {

	private static ArrayList<String> sortedStepList = new ArrayList<String>();

	public static ArrayList<String> getSortedStepList(int[] unsorted) {
		sortedStepList.clear();
		getSortedList(unsorted);
		return sortedStepList;
	}

	public static int[] getSortedList(int[] unsorted) {

		int[] first = ArrayTools
				.copyWithRange(unsorted, 0, unsorted.length / 2);
		int[] second = ArrayTools.copyWithRange(unsorted, unsorted.length / 2,
				unsorted.length);
		sortedStepList.add("First array:");
		sortedStepList.add(Arrays.toString(first));
		sortedStepList.add("Second array:");
		sortedStepList.add(Arrays.toString(second));

		if (first.length > 1) {
			first = getSortedList(first);
		}

		if (second.length > 1) {
			second = getSortedList(second);
		}
		int[] merged = merge(first, second);
		sortedStepList.add("Merged array:");
		sortedStepList.add(Arrays.toString(merged));
		return merged;

	}

	public static int[] merge(int[] first, int[] second) {
		int[] merged = new int[first.length + second.length];
		int firstPointer = 0;
		int secondPointer = 0;
		for (int i = 0; i < merged.length; i++) {
			if (firstPointer < first.length) {
				if (secondPointer < second.length) {
					if (first[firstPointer] < second[secondPointer]) {
						merged[i] = first[firstPointer];
						firstPointer++;
					} else {
						merged[i] = second[secondPointer];
						secondPointer++;
					}
				} else {
					merged[i] = first[firstPointer];
					firstPointer++;
				}
			} else {
				merged[i] = second[secondPointer];
				secondPointer++;
			}

		}
		return merged;
	}
}
