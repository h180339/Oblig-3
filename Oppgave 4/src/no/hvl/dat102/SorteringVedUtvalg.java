package no.hvl.dat102;

public class SorteringVedUtvalg {
	public static <T extends Comparable<T>> void selectionSort(T[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int iSmallest = i;

			for (int j = i + 1; j < list.length; j++) {
				if (list[iSmallest].compareTo((list[j])) > 0) {
					iSmallest = j;
				}
			}
			T iSwap = list[iSmallest];
			list[iSmallest] = list[i];
			list[i] = iSwap;

		}
	}
}
