package Lecture17;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries trie = new Tries();
		trie.add("art");
		trie.add("arts");
		trie.add("bug");
		trie.add("boy");
		trie.add("see");
		trie.add("sea");
		trie.add("seen");
		trie.display();

//		System.out.println(trie.search("art"));
//		System.out.println(trie.search("arts"));
//		System.out.println(trie.search("artist"));

		trie.displayAstree();
		System.out.println("*************************");
		trie.remove("arts");

		trie.display();
		trie.displayAstree();
		System.out.println("*************************");
		trie.remove("art");
		trie.display();
		trie.displayAstree();

	}

}
