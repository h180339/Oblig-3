package no.hvl.dat102;

public class SolveTowers {

	public static void main(String[] args) {
		TowersOfHanoi towers = new TowersOfHanoi(4);
		towers.solve();
		System.out.println(towers.flyttinger);
	}

}
