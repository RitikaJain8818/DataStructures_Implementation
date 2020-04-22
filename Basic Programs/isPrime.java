package Lecture1;

public class isPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 4;
		int divisor = 2;

		while (divisor < num) {
			if (num % divisor == 0) {
				System.out.println("Not Prime");
				return;
			}
			divisor++;
		}
		System.out.println("Prime");
	}

}
