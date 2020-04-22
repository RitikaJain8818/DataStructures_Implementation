package Lecture6;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PD(5);
		// PI(5);
		// PDI(5);
		// pdiskip(5);
		// System.out.println(fact(3));
		// System.out.println(power(2, 5));
		// System.out.println(fib(5));
		//
		// int[] arr = { 3, 5, 6, 18, 10 };
		// System.out.println(isSorted(arr, 0));

		int[] arr = { 3, 8, 6, 8, 8, 7 };
		System.out.println(firstIndex(arr, 0, 8));
		System.out.println(lastIndex(arr, 0, 8));

		int[] ans = allIndices(arr, 0, 8, 0);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		pattern(5, 1, 1);
	}

	public static void PD(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		PD(n - 1);
	}

	public static void PI(int n) {
		if (n == 0) {
			return;
		}

		PI(n - 1);
		System.out.println(n);
	}

	public static void PDI(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	public static void pdiskip(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 == 1) {
			System.out.println(n);
		}
		pdiskip(n - 1);
		if (n % 2 == 0) {
			System.out.println(n);
		}
	}

	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}

		int fnm1 = fact(n - 1);
		int fn = n * fnm1;
		return fn;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int pnm1 = power(x, n - 1);
		int pn = x * pnm1;
		return pn;
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fibnm1 = fib(n - 1);
		int fibnm2 = fib(n - 2);
		int fibn = fibnm1 + fibnm2;
		return fibn;
	}

	public static boolean isSorted(int[] arr, int si) {
		if (si == arr.length - 1) {
			return true;
		}

		if (arr[si] > arr[si + 1]) {
			return false;
		} else {
			boolean restans = isSorted(arr, si + 1);
			return restans;
		}
	}

	public static int firstIndex(int[] arr, int si, int num) {
		if (si == arr.length) {
			return -1;
		}
		if (arr[si] == num) {
			return si;
		} else {
			int restans = firstIndex(arr, si + 1, num);
			return restans;
		}
	}

	public static int lastIndex(int[] arr, int si, int num) {
		if (si == arr.length) {
			return -1;
		}
		int ans = lastIndex(arr, si + 1, num);
		if (ans != -1) {
			return ans;
		} else {
			if (arr[si] == num) {
				return si;
			} else {
				return -1;
			}
		}
	}

	public static int[] allIndices(int[] arr, int si, int num, int count) {
		if (si == arr.length) {
			int[] br = new int[count];
			return br;
		}
		int[] indices = null;
		if (arr[si] == num) {
			indices = allIndices(arr, si + 1, num, count + 1);
		} else {
			indices = allIndices(arr, si + 1, num, count);
		}

		if (arr[si] == num) {
			indices[count] = si;
		}
		return indices;
	}

	public static void pattern(int n, int row, int col) {
		if (row > n) {
			return;
		}
		if (col > row) {
			System.out.println();
			pattern(n, row + 1, 1);
			return;
		}
		System.out.print("*");
		pattern(n, row, col + 1);
	}

}
