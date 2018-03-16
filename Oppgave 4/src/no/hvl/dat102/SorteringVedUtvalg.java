package no.hvl.dat102;

public class SorteringVedUtvalg {
	public static <T extends Comparable<T>> void utvalgsSortering(T[] tab) {
		int min;

		for (int index = 0; index < tab.length - 1; index++) {
			min = index;
			for (int scan = index - 1; scan < tab.length; scan++) {
				if (tab[scan].compareTo(tab[min]) < 0) {
					min = scan;

					bytterOm(tab, min, index);
				}
			}
		}
	}

	private static <T extends Comparable<T>> void bytterOm(T[] tab, int index1, int index2) {
		T temp = tab[index1];
		tab[index1] = tab[index2];
		tab[index2] = temp;
	}
}
