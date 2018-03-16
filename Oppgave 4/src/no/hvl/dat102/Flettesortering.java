package no.hvl.dat102;

public class Flettesortering {
	@SuppressWarnings("ikke skjekket")
	public static <T extends Comparable<T>> void mergeSort(T[] list) {
		if (list.length > 1) {
			
			T[] firsthalf = (T[]) new Comparable[list.length / 2];
			System.arraycopy(list, 0, firsthalf, 0, list.length / 2);
			mergeSort(firsthalf);

			// sikkerer at vi får med oss alt i tilfelle list er av oddetall
			int secondHalfLength = list.length - (list.length / 2);
			T[] secondHalf = (T[]) new Comparable[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);

			T[] temp = merge(firsthalf, secondHalf, list);
			System.arraycopy(temp, 0, list, 0, temp.length);

		}
	}

	public static <T extends Comparable<T>> T[] merge(T[] firsthalf, T[] secondHalf, T[] list) {
		int firstHalfIndex = 0, secondHalfIndex = 0, listIndex = 0;

		while (firstHalfIndex < firsthalf.length && secondHalfIndex < secondHalf.length) {
			if (firsthalf[firstHalfIndex].compareTo(secondHalf[secondHalfIndex]) < 0) {
				list[listIndex++] = firsthalf[firstHalfIndex++];
			} else {
				list[listIndex++] = secondHalf[secondHalfIndex++];

			}
		}
		while (firstHalfIndex < firsthalf.length) {
			list[listIndex++] = firsthalf[firstHalfIndex++];
		}

		while (secondHalfIndex < secondHalf.length) {
			list[listIndex++] = firsthalf[secondHalfIndex++];
		}
		return list;
	}

}
