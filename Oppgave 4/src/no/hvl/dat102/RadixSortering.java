package no.hvl.dat102;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSortering {
	public static void main(String[] args) {
		int[] tabell = { 123, 398, 210, 19, 528, 513, 129, 294 };
		final int RADIX = 10;
		ArrayList<Integer> bøtteTabell[] = new ArrayList[RADIX];
		for (int teller = 0; teller < bøtteTabell.length; teller++) {
			bøtteTabell[teller] = new ArrayList<>();
		}
		// sorter inn i bøtetabell
		boolean maxTallnåd = false;
		int temp = -1, posisjon = 1;
		while (!maxTallnåd) {
			maxTallnåd = true;
			for (Integer element : tabell) {
				temp = element / posisjon;
				bøtteTabell[temp % RADIX].add(element);
				if (maxTallnåd && temp > 0) {
					maxTallnåd = false;
				}
			}

			// plasserer tilbake i oprinnelig tabell
			int a = 0;
			for (int b = 0; b < RADIX; b++) {
				for (Integer i : bøtteTabell[b]) {
					tabell[a++] = i;
				}
				bøtteTabell[b].clear();
			}
			posisjon = posisjon * RADIX;
		}
		System.out.println("Listen etter fletting" + "\n" + Arrays.toString(tabell));
	}
}
