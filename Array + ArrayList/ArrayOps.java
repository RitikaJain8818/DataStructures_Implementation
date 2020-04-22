package Lecture4;

public class ArrayOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = { 10, 20, 30, 40, 50 };
		//
		// System.out.println(max(arr));
		//
		// System.out.println(linearSearch(arr, 40));
		// System.out.println(linearSearch(arr, 400));
		//
		// System.out.println(BinarySearch(arr, 200));
		//
		// display(arr);
		// reverse(arr);
		// display(arr);

		int[] arr = { 50, 40, 30, 20, 10 };
		display(arr);
		// bubbleSort(arr);
		selectionSort(arr);
		display(arr);

	}

	public static int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int linearSearch(int[] arr, int element) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element) {
				return i;
			}
		}

		return -1;
	}

	public static int BinarySearch(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mi = (start + end) / 2;
			if (arr[mi] == element) {
				return mi;
			} else if (arr[mi] > element) {
				end = mi - 1;
			} else {
				start = mi + 1;
			}
		}

		return -1;
	}

	public static void reverse(int[] arr) {
		int beg = 0, end = arr.length - 1;
		while (beg <= end) {
			int temp = arr[beg];
			arr[beg] = arr[end];
			arr[end] = temp;
			beg++;
			end--;
		}
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void bubbleSort(int[] arr) {
		int passes = arr.length - 1;
		for (int pass = 1; pass <= passes; pass++) {
			for (int j = 0; j < arr.length - pass; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				// display(arr);
			}
			// display(arr);
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min_index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min_index]) {
					min_index = j;
				}
			}

			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}

}
