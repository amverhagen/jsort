package main;

import java.util.Arrays;

import sorters.Merge;

public class MergeTester {

	public static void main(String[] args) {
		int[] unsorted = { 3, 1, 10, 99, 4, 6, 5, 5 , 13, 21};
		unsorted = Merge.getSortedList(unsorted);
		System.out.println(Arrays.toString(unsorted));

		int[] first = { 4, 6, 7 };
		int[] second = { 5, 10, 15, 20, 33, 44, 50 };
		int[] merged = Merge.merge(first, second);
		System.out.println(Arrays.toString(merged));
	}

}
