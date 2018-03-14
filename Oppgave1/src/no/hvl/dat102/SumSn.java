package no.hvl.dat102;
public class SumSn {

	public static int oppsum(int n) {
		if (n == 1) {
			return 1;
		} else {
			return oppsum(n - 1) + n;
		}
	}

	// 5an-1 -6an-2 +2
	public static int hvertledd(int n) {
		if (n > 1) {
			return 5 * hvertledd(n - 1) - 6 * hvertledd(n - 2) + 2;
		} else if(n == 1) {
			return 5;
		} else {
			return 2;
		}
	}

	public static void main(String[] args) {
		System.out.println(oppsum(100));

		System.out.println("----------------------");

		// test hvert ledd test
		for (int i = 0; i < 10; i++) {
			System.out.println(hvertledd(i));
		}
	}
}
