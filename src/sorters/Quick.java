package sorters;

import java.util.ArrayList;
import java.util.Arrays;

import tools.ArrayTools;

public class Quick {
	private static ArrayList<String> stepList = new ArrayList<String>();

	public static int[] getSortedList(int[] unsorted) {
		stepList.add("New array " + Arrays.toString(unsorted));
		System.out.println("Array: " + Arrays.toString(unsorted));
		if (unsorted.length <= 1)
			return unsorted;
		int pivot = unsorted[unsorted.length - 1];
		stepList.add("Pivot is " + pivot);
		int wall = 0;
		for (int i = 0; i < unsorted.length - 1; i++) {
			if (unsorted[i] <= pivot) {
				int temp = unsorted[i];
				unsorted[i] = unsorted[wall];
				unsorted[wall] = temp;
				wall++;
			}
		}
		unsorted[unsorted.length - 1] = unsorted[wall];
		unsorted[wall] = pivot;
		stepList.add("After swaps:");
		stepList.add(Arrays.toString(unsorted));
		int[] firstHalf = ArrayTools.copyWithRange(unsorted, 0, wall);
		firstHalf = Quick.getSortedList(firstHalf);
		int[] secondHalf = Arrays.copyOfRange(unsorted, wall, unsorted.length);
		secondHalf = Quick.getSortedList(secondHalf);
		int[] concated = ArrayTools.concatIntArrays(firstHalf, secondHalf);
		stepList.add("Concated array:\n" + Arrays.toString(concated));
		return concated;
	}

	public static ArrayList<String> getSortedStepList(int[] unsorted) {
		stepList.clear();
		getSortedList(unsorted);
		return stepList;
	}
}
