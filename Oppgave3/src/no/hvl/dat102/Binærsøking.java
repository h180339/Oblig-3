package no.hvl.dat102;

public class Binærsøking {
	
	public static int binærsøkling(int[] tab, int tall) {
		int start = 0;
		int slutt = tab.length - 1;
		
		while (start <= slutt) {
			
			int mid = (start + slutt) / 2;
			if (tall == tab[mid]) {
				return mid;
			} else if (tall < tab[mid]) {
				slutt = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] liste = { 2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31 };
		System.out.println(binærsøkling(liste, 8));
	}
}