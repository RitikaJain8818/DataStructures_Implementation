package Lecture5;

public class insertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] arr= {50,40,30,20,10};
      
      display(arr);
      insertionSort(arr);
      display(arr);
	}
	
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0&&arr[j]<arr[j-1];j--) {
				int temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
			}
		}
	}

}
