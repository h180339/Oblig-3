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
	
	
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		System.out.println("oppgi størreslen på tabellen");
		Integer[] tabell = listeGenerator(input.nextInt());
		System.out.println("Listen før fletting" + "\n" + Arrays.toString(tabell));
		long Starttid = System.nanoTime();
		//flettesortering test	
		//Flettesortering mergesort = new Flettesortering();
		//mergesort.mergeSort(tabell);
		
		//boblesortering test
		//Boblesortering boblesort = new Boblesortering();
		//boblesort.bubbleSort(tabell);
		
		//QuickSort Test
		//QuickSort Qsort = new QuickSort();
		//Qsort.quickSort(tabell);
		
		//sortering ved innsetting Test
		//SorteringVedInnsetting SortVinn = new SorteringVedInnsetting();
		//SortVinn.innsettingSort(tabell);
		
		// sortering ved utvalg
		//SorteringVedUtvalg utvalg = new SorteringVedUtvalg();
		//utvalg.selectionSort(tabell);
		
		//flettesortering test
		Flettesortering.mergeSort(tabell);
		long sluttid = System.nanoTime();
		
		System.out.println("Listen etter fletting" + "\n" + Arrays.toString(tabell));
		input.close();
		System.out.println("Kjøringen tok " + (sluttid-Starttid) + " ns");
		
	}
}
