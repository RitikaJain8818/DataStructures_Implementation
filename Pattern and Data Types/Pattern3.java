package Lecture2;

public class Pattern3 {
	public static void main(String[] args) {
		int n = 5;
		int nst = n;
		int row = 1;
		while (row <= n) {
			int starnum = 1;
			while (starnum <= nst) {
				System.out.print("* ");
				starnum++;
			}
			nst--;
			System.out.println();
			row++;
		}
	}

}
