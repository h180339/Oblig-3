package no.hvl.dat102;

public class Boblesortering {
	private static <T extends Comparable<T>> void bytterOm(T[] tab, int min, int max) {
		T temp = tab[min];
		tab[min] = tab[max];
		tab[max] = temp;
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] tab) {
		int posisjon, scan;

		for (posisjon = tab.length - 1; posisjon >= 0; posisjon--) {
			for (scan = 0; scan <= posisjon - 1; scan++) {
				if (tab[scan].compareTo(tab[scan + 1]) > 0) {
					bytterOm(tab, scan, scan + 1);
				}
			}
		}
	}

}
