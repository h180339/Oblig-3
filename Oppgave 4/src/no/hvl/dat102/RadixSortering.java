package no.hvl.dat102;

import java.util.ArrayList;
import java.util.Arrays;


public class RadixSortering {
	public static void main(String[] args) {
		int[] tabell = { 7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241, 6589, 6622, 1211 };
		final int RADIX = 10;
		ArrayList<Integer> bøtteTabell[] = new ArrayList[RADIX];
		for(int teller = 0; teller<bøtteTabell.length; teller++) {
			bøtteTabell[teller] = new ArrayList<>();
		}
		boolean maxTallnåd = false;
		int temp = -1, posisjon = 1;
		while(!maxTallnåd) {
			maxTallnåd = true;
			for(Integer element: tabell) {
				temp = element / posisjon;
				bøtteTabell[temp % RADIX].add(element);
				if(maxTallnåd && temp>0) {
					maxTallnåd = false;
				}
			}
			int a = 0;
			for(int b = 0; b<RADIX; b++) {
				for(Integer i:bøtteTabell[b]) {
					tabell[a++] = i;
				}
				bøtteTabell[b].clear();
			}		
			posisjon = posisjon * RADIX;
		}
			Arrays.stream(tabell).forEach(System.out::println);
	}
}
