package Lecture12;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		// list.addFirst(20);
		// list.addLast(50);
		// list.display();
		// list.addFirst(10);
		// list.display();
		//
		// list.addAt(2, 30);
		// list.display();
		//
		// list.addAt(3, 40);
		// list.display();
		//
		// list.addFirst(5);
		// list.addLast(60);
		// list.addAt(2, 25);
		// list.display();
		//
		// list.removeFirst();
		// list.display();
		//
		// list.removeLast();
		// list.display();
		//
		// list.removeAt(1);
		// list.display();

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);

		list.addLast(40);
		list.addLast(50);

		list.display();
//		list.reverseDR();
//		list.display();

//		System.out.println(list.mid());
//		System.out.println(list.KthNodeFromLast(2));

		list.createloop();
		System.out.println(list.detectloop());

	}

}
