package main;

import java.util.Arrays;

import sorters.Merge;

public class MergeTester {

	public static void main(String[] args) {
		int[] unsorted = { 2,10,9,15,19,19,21,21,66,400,2};
		unsorted = Merge.getSortedList(unsorted);
		System.out.println(Arrays.toString(unsorted));

		int[] first = { 4, 6, 7 };
		int[] second = { 5, 10, 15, 20, 33, 44, 50 };
		int[] merged = Merge.merge(first, second);
		System.out.println(Arrays.toString(merged));
	}

}
