package Lecture12;

public class LinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);
		this.head = node;

		if (this.isEmpty()) {
			this.tail = node;
		}

		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);
		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	private Node getNodeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		int counter = 0;
		Node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}

		return temp;
	}

	public void addAt(int index, int data) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid index");
		}

		if (index == 0) {
			this.addFirst(data);
		} else if (index == this.size) {
			this.addLast(data);
		} else {
			Node temp = this.getNodeAt(index - 1);
			Node node = new Node(data, temp.next);
			temp.next = node;
			this.size++;
		}

	}

	public void removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		this.size--;
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node temp = this.getNodeAt(this.size - 2);
			temp.next = null;
			this.tail = temp;
		}
		this.size--;
	}

	public void removeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		if (index == 0) {
			this.removeFirst();
		} else if (index == this.size - 1) {
			this.removeLast();
		} else {
			Node temp = this.getNodeAt(index - 1);
			temp.next = temp.next.next;
			this.size--;
		}
	}

	public void display() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public void reverseDI() throws Exception {
		int left = 0, right = this.size - 1;
		while (left <= right) {
			Node lnode = this.getNodeAt(left);
			Node rnode = this.getNodeAt(right);
			int temp = lnode.data;
			lnode.data = rnode.data;
			rnode.data = temp;
			left++;
			right--;
		}

	}

	public void reversePI() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node tempprev = prev;
			Node tempcurr = curr;

			prev = curr;
			curr = curr.next;
			tempcurr.next = tempprev;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void reversePR() {
		this.reveresePR(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reveresePR(Node node) {
		if (node == this.tail) {
			return;
		}
		reveresePR(node.next);
		node.next.next = node;
	}

	// public void reverseDR() {
	// reverseDR(this.head, this.head, 0);
	// }
	//
	// public void reverseDR(Node left, Node right, int level) {
	// if (right == null) {
	// return;
	// }
	// reverseDR(left, right.next, level + 1);
	// if (level >= this.size / 2) {
	// int temp = left.data;
	// left.data = right.data;
	// right.data = temp;
	// left = left.next;
	// }
	// }

	public void reverseDR() {
		HeapMover obj = new HeapMover(this.head);
		reverseDR(obj, this.head, 0);
	}

	public void reverseDR(HeapMover obj, Node right, int level) {
		if (right == null) {
			return;
		}
		reverseDR(obj, right.next, level + 1);
		if (level >= this.size / 2) {
			int temp = obj.node.data;
			obj.node.data = right.data;
			right.data = temp;
			obj.node = obj.node.next;
		}
	}

	private class HeapMover {
		Node node;

		public HeapMover(Node node) {
			// TODO Auto-generated constructor stub
			this.node = node;
		}
	}

	public int mid() {
		return getMidNode().data;
	}

	private Node getMidNode() {

		Node fast = this.head, slow = this.head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public int KthNodeFromLast(int k) throws Exception {
		if (k < 1 || k > this.size) {
			throw new Exception("Invalid index K");
		}
		Node slow = this.head;
		Node fast = this.head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;
	}

	public void createloop() throws Exception {
		Node node = this.getNodeAt(1);
		this.tail.next = node;
	}

	public boolean detectloop() {
		Node slow = this.head;
		Node fast = this.tail;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
