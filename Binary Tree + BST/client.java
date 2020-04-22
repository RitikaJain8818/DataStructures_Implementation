package Lecture13and14;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 50 true 46 true 49 false false true 76 false false true 81 true 84 false false true 12 false false
		BinaryTree tree = new BinaryTree();
		tree.display();
		
		System.out.println(tree.size2());
		System.out.println(tree.max());
		System.out.println(tree.min());
		System.out.println(tree.height());
		System.out.println(tree.find(100));
		
		tree.preOrder();
		System.out.println();
		tree.postOrder();
		System.out.println();
		tree.inOrder();
		System.out.println("*****************");
		System.out.println(tree.lca(49, 46));
	}

}
