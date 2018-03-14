package no.hvl.dat102;

public class SolveTowers {

	public static void main(String[] args) {
		long startTid = System.nanoTime();
		TowersOfHanoi towers = new TowersOfHanoi(28);
		towers.solve();
		System.out.println("Antall flyttinger: " + towers.flyttinger);
		long slutttid = System.nanoTime();
		System.out.print("kjøringen tok: " + (slutttid - startTid) + " ns");
	}

}
