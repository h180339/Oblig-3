package no.hvl.dat102;

import java.util.Random;

public class KlientKvikksort {

	public static Integer[] listeGenerator(int størrelse) {
		Integer[] Tabell = new Integer[størrelse];
		Random randTall = new Random();

		for(int i = 0; i < størrelse; i++) {
			Tabell[i] = randTall.nextInt(100);
		}
		return Tabell;
	}

	public static void main(String[] args) {
		long totaltid = 0;
		long Starttid = System.nanoTime();
		for(int i = 0; i < 10; i++) {
			Integer[] tabell = listeGenerator(32000);
			// System.out.println("Listen før fletting" + "\n" + Arrays.toString(tabell));


			// sortering ved innsetting Test
			SoekingOgSortering.kvikkSortNy(tabell, 0 , tabell.length -1);


		}
		long sluttid = System.nanoTime();
		System.out.println("gjennomsintlig kjøretid = " + (sluttid - Starttid) / 10 + " ns");
		// System.out.println("Listen etter fletting" + "\n" + Arrays.toString(tabell));

		// System.out.println("Kjøringen tok " + (sluttid - Starttid) + " ns");

	}


}
