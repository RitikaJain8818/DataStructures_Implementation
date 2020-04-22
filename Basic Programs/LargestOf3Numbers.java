package Lecture1;

public class LargestOf3Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 100;
		int c = 500;
		//
		// if (a > b && a > c) {
		// System.out.println("A is largest");
		// } else {
		// if (b > a && b > c) {
		// System.out.println("B is largest");
		// } else {
		// System.out.println("C is Largest");
		// }
		// }

		if (a >= b && a >= c) {
			System.out.println("A is Largest");
			return;
		} else if (b >= a && b >= c) {
			System.out.println("B is Largest");
			return;
		}
		System.out.println("C is largest");

		// a = 400;
		// if (a == 10) {
		// System.out.println(a + " A");
		// } else if (a == 30) {
		// System.out.println(a + " B");
		// } else if (a == 40) {
		// System.out.println(a + "C");
		// } else {
		// System.out.println("A not matched ");
		// }

	}

}
