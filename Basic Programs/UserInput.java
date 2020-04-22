package Lecture1;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Input principal");
		int p = sc.nextInt();
		System.out.println("Input ROI");
		int r = sc.nextInt();
		System.out.println("Input Time");
		int t = sc.nextInt();

		int si = (p * r * t) / 100;
		System.out.println(si);
		
	}

}
