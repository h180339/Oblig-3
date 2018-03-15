package no.hvl.dat102;

public class SorteringVedInnsetting {

	public static <T extends Comparable<T>> void innsettingSort(T[] tab) {
		for (int index = 1; index < tab.length; index++) {
			T Nøkkel = tab[index];
			int posisjon = index;
			while (posisjon > 0 && tab[posisjon - 1].compareTo(Nøkkel) > 0) {
				tab[posisjon] = tab[posisjon - 1];
				posisjon--;
			}
			tab[posisjon] = Nøkkel;
		}

	}

}
