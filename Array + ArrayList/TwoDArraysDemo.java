package Lecture5;

public class TwoDArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr;
		// System.out.println(arr);

//		arr = new int[3][3];
//		System.out.println(arr);
//		System.out.println(arr[0]);
//		System.out.println(arr[0][0]);
//
//		arr[0][0] = 10;
//		arr[0][1] = 20;
//		arr[0][2] = 30;
//		display(arr);
		//arr=new int[][4];
		arr=new int[3][];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr.length);
		
		arr[0]=new int[4];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr.length);
		
	//	System.out.println(arr[1].length);
		
		arr[2]=new int[2];
		arr[1]=new int[3];
		display(arr);
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
