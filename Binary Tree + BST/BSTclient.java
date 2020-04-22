package Lecture13and14;

public class BSTclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BST tree = new BST();
		tree.add(50);
		tree.add(25);
		tree.add(75);

		tree.add(12);
		tree.add(37);

		tree.add(62);
		tree.add(87);
		tree.add(30);
		tree.add(70);

		tree.display();
		
		System.out.println(tree.max());
		System.out.println(tree.min());
		
		tree.remove(50);
		System.out.println("****************");
		tree.display();
	}

}
