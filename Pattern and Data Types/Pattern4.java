package Lecture2;

public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int nst = 1;
		int row = 1;
		int value=1;
		while (row <= n) {
			int starnum = 1;
			while (starnum <= nst) {
				System.out.print(value+" ");
				starnum++;
				value++;
			}
			nst++;
			System.out.println();
			row++;
		}
	}
}
