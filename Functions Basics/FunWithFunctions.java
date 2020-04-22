package Lecture3;

public class FunWithFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Part 1
		// HelloFun();

		// Part 2
		// HelloFun();
		// HelloFun();

		// Part 3
		// HelloFun();
		// HelloGun();
		//

		// Part 4
		// int x=10,y=20,z=30;
		// if(x==100) {
		// z=50;
		// System.out.println(x);
		// System.out.println(z);
		// }
		// System.out.println(y);
		// System.out.println(z);
//		// Part 5
//		int a = 10, b = 20;
//		System.out.println(a);
//		System.out.println(b);
//		FunWithArguments(b,a);
		
		//Part 6
//		int p=1000,r=10,t=1;
//		int si=0;
//	//	System.out.println(SI(p, r, t));
//		si=SI(p, r, t);
//		System.out.println(si);
//
//		si=50;
		
		//Part 7
		int a=10,b=20;
		System.out.println(a+","+b);
		swap(a,b);
		System.out.println(a+","+b);
		
	}

	public static void HelloFun() {
		System.out.println("HelloFun");
		HelloGun();
	}

	public static void HelloGun() {
		System.out.println("HelloGun");
	}

	public static void FunWithArguments(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
	
	public static int SI(int p,int r,int t ) {
		int si=(p*r*t)/100;
		return si;
	}
	
	public static void swap(int a,int b) {
		System.out.println(a+","+b);
		int temp=a;
		a=b;
		b=temp;
		System.out.println(a+","+b);
	}

}
