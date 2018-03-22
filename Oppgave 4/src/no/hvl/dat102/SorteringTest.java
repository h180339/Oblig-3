package no.hvl.dat102;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SorteringTest {

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
		for(int i = 0; i < 100; i++) {
			Integer[] tabell = listeGenerator(128000);
			// System.out.println("Listen før fletting" + "\n" + Arrays.toString(tabell));

			// flettesortering test

			Flettesortering.mergeSort(tabell);

			// boblesortering test
			//Boblesortering.bubbleSort(tabell);

			// QuickSort Test
			//QuickSort.quickSort(tabell);

			// sortering ved innsetting Test
			//SorteringVedInnsetting.innsettingSort(tabell);

			// sortering ved utvalg
			// SorteringVedUtvalg.selectionSort(tabell);



		}
		long sluttid = System.nanoTime();
		System.out.println("gjennomsintlig kjøretid = " + (sluttid - Starttid) / 100 + " ns");
		// System.out.println("Listen etter fletting" + "\n" + Arrays.toString(tabell));

		// System.out.println("Kjøringen tok " + (sluttid - Starttid) + " ns");

	}

}
