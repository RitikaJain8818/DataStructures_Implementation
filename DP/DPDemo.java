package Lecture18;

public class DPDemo {

	public static long start;
	public static long end;

	public static void start() {
		start = System.currentTimeMillis();
	}

	public static long end() {
		end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 20;
		int[][] strg = new int[n + 1][n + 1];
//		start();
//		System.out.println(fib(n));
//		System.out.println("The fib took time " + end());
//
//		start();
//		System.out.println(fibRS(n, strg));
//		System.out.println("The fibRS took time " + end());
//
//		start();
//		System.out.println(fibIS(n));
//		System.out.println("The fibIS took time " + end());
//	
//		start();
//		System.out.println(cbp(n, 0));
//		System.out.println("The cbp took time " + end());
//
//		start();
//		System.out.println(cbpRS(n, 0, strg));
//		System.out.println("The cbp took time " + end());
//
//		start();
//		System.out.println(cbpIS(n, 0));
//		System.out.println("The cbpIS took time " + end());
//		
//		start();
//		System.out.println(cmp(n, n, 0, 0));
//		System.out.println("The cmp took time " + end());
//
//		start();
//		System.out.println(cmpRS(n, n, 0, 0, strg));
//		System.out.println("The cmRS took time " + end());
//		
//		start();
//		System.out.println(cmpIS(n, n, 0, 0));
//		System.out.println("The cmpIS took time " + end());

		String str1 = "abgbsscscsisjcjv", str2 = "aggbicjjcjcscskjsc";
//		start();
//		System.out.println(lcs(str1, str2));
//		System.out.println("lcs took time " + end());
//		
//		start();
//		System.out.println(lcsI(str1, str2));
//		System.out.println("lcsI took time " + end());
//		
//		start();
//		System.out.println(editDistance(str1, str2));
//		System.out.println("ed took time " + end());
//
//		start();
//		System.out.println(editDistanceI(str1, str2));
//		System.out.println("edI took time " + end());
//	
		
		int[] arr= {10,20,30,40,50,60};
		strg=new int[arr.length][arr.length];
		System.out.println(mcm(arr,0,arr.length-1));
		System.out.println(mcmRS(arr,0,arr.length-1,strg));
		
	
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

	public static int fibRS(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int fibnm1 = fibRS(n - 1, strg);
		int fibnm2 = fibRS(n - 2, strg);
		int fibn = fibnm1 + fibnm2;
		strg[n] = fibn;
		return fibn;
	}

	public static int fibIS(int n) {
		int[] strg = new int[n + 1];
		// seed
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int cbp(int end, int curr) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count = count + cbp(end, curr + dice);
		}

		return count;
	}

	public static int cbpRS(int end, int curr, int[] strg) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int count = 0;
		if (strg[curr] != 0) {
			return strg[curr];
		}
		for (int dice = 1; dice <= 6; dice++) {
			count = count + cbpRS(end, curr + dice, strg);
		}
		strg[curr] = count;

		return count;

	}

	public static int cbpIS(int end, int curr) {
		int[] strg = new int[end + 1];

		// seed
		strg[end] = 1;

		for (int i = end - 1; i >= curr; i--) {
			int count = 0;
			for (int dice = 1; dice <= 6 && dice + i < strg.length; dice++) {
				count = count + strg[dice + i];
			}
			strg[i] = count;
		}

		return strg[curr];
	}

	public static int cmp(int er, int ec, int cr, int cc) {
		// positive base case
		if (cr == er && cc == ec) {
			return 1;
		}
		// negative base case
		if (cr > er || cc > ec) {
			return 0;
		}
		int count = 0;
		count = count + cmp(er, ec, cr, cc + 1);
		count = count + cmp(er, ec, cr + 1, cc);
		return count;

	}

	public static int cmpRS(int er, int ec, int cr, int cc, int[][] strg) {
		// positive base case
		if (cr == er && cc == ec) {
			return 1;
		}
		// negative base case
		if (cr > er || cc > ec) {
			return 0;
		}
		int count = 0;
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		count = count + cmpRS(er, ec, cr, cc + 1, strg);
		count = count + cmpRS(er, ec, cr + 1, cc, strg);
		strg[cr][cc] = count;
		return count;

	}

	public static int cmpIS(int er, int ec, int cr, int cc) {
		int[][] strg = new int[er + 1][ec + 1];

		// seed
		strg[er][ec] = 1;
		for (int i = er; i >= cr; i--) {
			for (int j = ec; j >= cc; j--) {
				if (i == er || j == ec) {
					strg[i][j] = 1;
				} else {
					strg[i][j] = strg[i + 1][j] + strg[i][j + 1];
				}
			}
		}

		return strg[cr][cc];

	}

	public static int lcs(String str1, String str2) {
		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}

		char cc1 = str1.charAt(0);
		char cc2 = str2.charAt(0);
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		int ans = 0;
		if (cc1 == cc2) {
			ans = 1 + lcs(ros1, ros2);
		} else {
			int f1 = lcs(str1, ros2);
			int f2 = lcs(ros1, str2);
			ans = Math.max(f1, f2);
		}

		return ans;

	}

	public static int lcsI(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		// seed
		strg[s1.length()][s2.length()] = 0;

		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length() || j == s2.length()) {
					strg[i][j] = 0;
					continue;
				}
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = 1 + strg[i + 1][j + 1];
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}
			}
		}

		return strg[0][0];
	}

	public static int editDistance(String str1, String str2) {
		if (str1.length() == 0) {
			return str2.length();
		}

		if (str2.length() == 0) {
			return str1.length();
		}

		char cc1 = str1.charAt(0);
		char cc2 = str2.charAt(0);
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		int ans = 0;
		if (cc1 == cc2) {
			ans = editDistance(ros1, ros2);
		} else {
			int f1 = 1 + editDistance(ros1, ros2);// replace
			int f2 = 1 + editDistance(str1, ros2);// deletion
			int f3 = 1 + editDistance(ros1, str2);// addition
			ans = Math.min(f1, Math.min(f2, f3));
		}

		return ans;
	}

	public static int editDistanceI(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		// seed
		strg[s1.length()][s2.length()] = 0;

		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length()){
					strg[i][j] = s2.length()-j;
					continue;
				}
				
				if (j == s2.length()){
					strg[i][j] = s1.length()-i;
					continue;
				}
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] =strg[i + 1][j + 1];
				} else {
					strg[i][j] = 1+Math.min(strg[i + 1][j+1], Math.min(strg[i][j + 1],strg[i+1][j]));
				}
			}
		}

		return strg[0][0];
	}
	
	public static int mcm(int[] arr,int si,int ei) {
		if(ei-si==1) {
			return 0;
		}
		int cost1=0;
		int cost2=0;
		int cost3=0;
		
		int myans=Integer.MAX_VALUE;
		for(int i=si;i<ei-1;i++) {	
			int tot_ops=0;
			int ops1=mcm(arr, si, i+1);
			int ops2=mcm(arr,i+1,ei);
			int ops3=arr[si]*arr[i+1]*arr[ei];
			tot_ops=ops1+ops2+ops3;
			myans=Math.min(myans, tot_ops);
		}
		return myans;
	}
	
	public static int mcmRS(int[] dims, int si, int ei, int[][] strg) {
		if (ei - si == 1) {
			return 0;
		}
		if (strg[si][si] != 0) {
			return strg[si][ei];
		}
		int myans = Integer.MAX_VALUE;
		int tot_cost = 0;
		int cost1 = 0;
		int cost2 = 0;
		int cost3 = 0;
		for (int i = si; i < ei - 1; i++) {
			cost1 = mcmRS(dims, si, i + 1, strg);
			cost2 = mcmRS(dims, i + 1, ei, strg);
			cost3 = dims[si] * dims[i + 1] * dims[ei];
			tot_cost = cost1 + cost2 + cost3;
			myans = Math.min(myans, tot_cost);
		}
		strg[si][ei] = myans;
		return myans;
	}
	
	

}
