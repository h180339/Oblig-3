package no.hvl.dat102;

public class QuickSort {
	public static <T extends Comparable<T>> void quickSort(T[] tab) {
		quickSort(tab, 0, tab.length - 1);
	}

	private static <T extends Comparable<T>> void bytterOm(T[] tab, int min, int max) {
		T temp = tab[min];
		tab[min] = tab[max];
		tab[max] = temp;
	}

	public static <T extends Comparable<T>> int partition(T[] tab, int min, int max) {
		T partitionElement;
		int left, right;
		int mid = (min + max) / 2;

		partitionElement = tab[mid];
		bytterOm(tab, mid, min);
		left = min;
		right = max;

		while (left < right) {
			while (left < right && tab[left].compareTo(partitionElement) <= 0) {
				left++;
			}
			while (tab[right].compareTo(partitionElement) > 0) {
				right--;
			}
			if (left < right) {
				bytterOm(tab, left, right);
			}

		}
		bytterOm(tab, min, right);
		return right;
	}

	public static <T extends Comparable<T>> void quickSort(T[] tab, int min, int max) {

		if (min < max) {
			int indexofpartion = partition(tab, min, max);
			quickSort(tab, min, indexofpartion - 1);
			quickSort(tab, indexofpartion + 1, max);
		}
	}
}
