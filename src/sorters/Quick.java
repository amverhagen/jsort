package sorters;

import java.util.Arrays;

import tools.ArrayTools;

public class Quick {

	public static int[] getSortedList(int[] unsorted) {
		System.out.println(Arrays.toString(unsorted));
		if (unsorted.length == 1)
			return unsorted;
		int pivot = unsorted[unsorted.length - 1];
		System.out.println("Pivot " + pivot);
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
		System.out.println(Arrays.toString(unsorted));
		System.out.println("Wall size " + wall);
		int[] firstHalf = ArrayTools.copyWithRange(unsorted, 0, wall);
		System.out.println("First half  " + Arrays.toString(firstHalf));
		firstHalf = Quick.getSortedList(firstHalf);
		int[] secondHalf = Arrays.copyOfRange(unsorted, wall, unsorted.length);
		System.out.println("Second half " + Arrays.toString(secondHalf));
		secondHalf = Quick.getSortedList(secondHalf);
		return ArrayTools.concatIntArrays(firstHalf, secondHalf);
	}
}
