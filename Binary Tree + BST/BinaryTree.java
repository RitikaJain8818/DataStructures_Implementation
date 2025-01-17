package Lecture13and14;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s, null, false);
	}

	private Node takeInput(Scanner s, Node parent, boolean isLeftOrRight) {
		if (parent == null) {
			System.out.println("Enter the data for the root node");
		} else {
			if (isLeftOrRight) {
				System.out.println("Enter the data for the left child of " + parent.data);
			} else {
				System.out.println("Enter the data for the right child of " + parent.data);
			}
		}
		int nodedata = s.nextInt();
		Node node = new Node(nodedata, null, null);
		this.size++;

		boolean choice = false;
		System.out.println("Do you have left child for " + node.data);
		choice = s.nextBoolean();
		if (choice) {
			node.left = takeInput(s, node, true);
		}

		choice = false;
		System.out.println("Do you have right child for " + node.data);
		choice = s.nextBoolean();
		if (choice) {
			node.right = takeInput(s, node, false);
		}

		return node;

	}

	public void display() throws Exception {
		if (this.root == null) {
			System.out.println("Root is null");
		} else {
			this.display(this.root);
		}

	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("END=>");
		}

		System.out.print(node.data);

		if (node.right != null) {
			System.out.print("<=" + node.right.data);
		} else {
			System.out.print("<=END");
		}

		System.out.println();
		if (node.left != null) {
			this.display(node.left);
		}

		if (node.right != null) {
			this.display(node.right);
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int lsize = this.size2(node.left);
		int rsize = this.size2(node.right);
		return lsize + rsize + 1;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int lmax = this.max(node.left);
		int rmax = this.max(node.right);
		return Math.max(node.data, Math.max(lmax, rmax));
	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int lmin = this.min(node.left);
		int rmin = this.min(node.right);
		return Math.min(node.data, Math.min(lmin, rmin));
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lheight = this.height(node.left);
		int rheight = this.height(node.right);
		return Math.max(lheight, rheight) + 1;

	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		} else if (find(node.left, data)) {
			return true;
		} else if (find(node.right, data)) {
			return true;
		} else {
			return false;
		}
	}

	public void preOrder() {
		this.preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder() {
		this.inOrder(this.root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public void postOrder() {
		this.postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	public int lca(int data1, int data2) {
		return this.lca(this.root, data1, data2).data;
	}

	private Node lca(Node node, int data1, int data2) {
		if (node == null) {
			return null;
		}
		if (node.data == data1 || node.data == data2) {
			return node;
		}

		Node llca = this.lca(node.left, data1, data2);
		Node rlca = this.lca(node.right, data1, data2);

		if (llca != null && rlca != null) {
			return node;
		} else if (llca != null) {
			return llca;
		} else if (rlca != null) {
			return rlca;
		} else {
			return null;
		}
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);
		while (!queue.isEmpty()) {
			Node rv = queue.removeFirst();
			System.out.print(rv.data + " ");
			if (rv.left != null) {
				queue.addLast(rv.left);
			}

			if (rv.right != null) {
				queue.addLast(rv.right);
			}
		}
	}

	public boolean isBST() {
		return this.isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		} else if (!this.isBST(node.left, min, node.data)) {
			return false;
		} else if (!this.isBST(node.right, node.data, max)) {
			return false;
		} else {
			return true;
		}
	}

}
