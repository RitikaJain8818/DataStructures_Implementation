package Lecture7;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(getSS("abc"));
		// System.out.println(getSSWAscii("ab"));
		// System.out.println(getPermutations("abc"));
		// System.out.println(getBoardPath(10, 0));

		printSS("abc", "");
		printPermutations("abc", "");

	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recResult = getSS(ros);
		for (int i = 0; i < recResult.size(); i++) {
			myresult.add(recResult.get(i));
			myresult.add(cc + recResult.get(i));
		}

		return myresult;
	}

	public static ArrayList<String> getSSWAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recResult = getSSWAscii(ros);
		for (int i = 0; i < recResult.size(); i++) {
			myresult.add(recResult.get(i));
			myresult.add(cc + recResult.get(i));
			myresult.add((int) cc + recResult.get(i));
		}

		return myresult;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recResult = getPermutations(ros);
		for (int i = 0; i < recResult.size(); i++) {
			String recString = recResult.get(i);
			for (int j = 0; j <= recString.length(); j++) {
				String mystring = recString.substring(0, j) + cc + recString.substring(j);
				myresult.add(mystring);
			}
		}
		return myresult;
	}

	public static ArrayList<String> getBoardPath(int end, int curr) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> recResult = null;
		ArrayList<String> myresult = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			recResult = getBoardPath(end, curr + dice);
			for (int i = 0; i < recResult.size(); i++) {
				myresult.add(dice + recResult.get(i));
			}
		}

		return myresult;
	}

	public static void printSS(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		printSS(ros, result);
		printSS(ros, result + cc);

	}

	public static void printPermutations(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(ros, result + cc);
		}
	}

}
