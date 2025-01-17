package Lecture17;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tries {
	private class Node {
		char data;
		HashMap<Character, Node> children;
		boolean isTerminal;

		Node(char data, boolean isTerminal) {
			this.data = data;
			this.children = new HashMap<>();
			this.isTerminal = isTerminal;
		}
	}

	Node root;
	int numwords;

	Tries() {
		this.root = new Node('\0', false);
		this.numwords = 0;
	}

	public void add(String word) {
		this.add(this.root, word);
	}

	private void add(Node node, String word) {
		if (word.length() == 0) {
			if (node.isTerminal) {
				// word already exists
			} else {
				this.numwords++;
				node.isTerminal = true;
			}
			return;
		}

		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(cc);
		if (child == null) {
			child = new Node(cc, false);
			node.children.put(cc, child);
		}

		this.add(child, ros);
	}

	public void display() {
		this.display(this.root, "");
	}

	private void display(Node node, String osf) {
		if (node.isTerminal) {
			System.out.println(osf);
		}

		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for (Map.Entry<Character, Node> entry : entries) {
			this.display(entry.getValue(), osf + entry.getKey());
		}
	}

	public boolean search(String word) {
		return this.search(this.root, word);
	}

	private boolean search(Node node, String word) {
		if (word.length() == 0) {
			if (node.isTerminal) {
				return true;
			} else {
				return false;
			}
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(cc);
		if (child == null) {
			return false;
		}

		return this.search(child, ros);

	}

	public void displayAstree() {
		this.displayAstree(this.root);
	}

	private void displayAstree(Node node) {

		String str = "";
		str = str + node.data + "=>";
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();

		for (Map.Entry<Character, Node> entry : entries) {
			str = str + entry.getKey() + ", ";
		}
		str = str + "END";
		System.out.println(str);
		for (Map.Entry<Character, Node> entry : entries) {
			this.displayAstree(entry.getValue());
		}
	}

	public void remove(String word) {
		this.remove(this.root, word);
	}

	private void remove(Node node, String word) {
		if (word.length() == 0) {
			if (node.isTerminal) {
				node.isTerminal = false;
				this.numwords--;
			} else {

			}
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(cc);
		if (child == null) {
			return;
		}

		this.remove(child, ros);
		
		if (!child.isTerminal && child.children.size() == 0) {
			node.children.remove(cc);
		}
	}
}
