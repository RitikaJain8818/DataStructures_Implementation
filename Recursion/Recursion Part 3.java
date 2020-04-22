package Lecture8;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(cmp(2, 2, 0, 0));
		// System.out.println(getMP(2, 2, 0, 0));
		// printMP(2, 2, 0, 0, "");
		//
		// boolean[][] board = new boolean[4][4];
		// System.out.println(countNQueens(board, 0));

		System.out.println(toh(3, "src", "dest", "helper"));
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

	public static ArrayList<String> getMP(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> hResult = getMP(er, ec, cr, cc + 1);
		ArrayList<String> vResult = getMP(er, ec, cr + 1, cc);
		for (int i = 0; i < hResult.size(); i++) {
			myresult.add("H" + hResult.get(i));
		}
		for (int i = 0; i < vResult.size(); i++) {
			myresult.add("V" + vResult.get(i));
		}

		return myresult;
	}

	public static void printMP(int er, int ec, int cr, int cc, String result) {
		if (cr == er && cc == ec) {
			System.out.println(result);
			return;
		}
		if (cr > er || cc > ec) {
			return;
		}
		printMP(er, ec, cr, cc + 1, result + "H");
		printMP(er, ec, cr + 1, cc, result + "V");
	}

	public static int countNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}

		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				count = count + countNQueens(board, row + 1);
				board[row][col] = false;
			}
		}

		return count;
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		for (int i = row; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < board[row].length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}

		return true;
	}

	public static int toh(int n, String src, String dest, String helper) {
		if (n == 0) {
			return 0;
		}
		int count = 0;
		count = count + toh(n - 1, src, helper, dest);
		System.out.println("move " + n + " th disc from " + src + " to " + dest);
		count++;
		count = count + toh(n - 1, helper, dest, src);
		return count;
	}

}
