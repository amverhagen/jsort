package tools;

public class ArrayCreator {

	public static int[] getRandomIntArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int) Math.ceil(Math.random() * 100);
		}
		return array;
	}
}
