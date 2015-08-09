package tools;

public class ArrayTools {

	public static int[] getRandomIntArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int) Math.ceil(Math.random() * 100);
		}
		return array;
	}

	public static int[] concatIntArrays(int[] first, int[] second) {
		int[] concat = new int[first.length + second.length];
		for (int i = 0; i < concat.length; i++) {
			if (i < first.length) {
				concat[i] = first[i];
			} else {
				concat[i] = second[i - first.length];
			}
		}
		return concat;
	}

	public static int[] copyWithRange(int[] array, int firstIndex,
			int secondIndex) {
		int[] copyArray = new int[secondIndex - firstIndex];
		for (int i = 0; i < copyArray.length; i++) {
			copyArray[i] = array[firstIndex + i];
		}
		return copyArray;
	}
}
