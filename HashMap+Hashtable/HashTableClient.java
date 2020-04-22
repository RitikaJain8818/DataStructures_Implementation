package Lecture15;

public class HashTableClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> map = new Hashtable<>(4);
		map.put("India", 300);
		//map.display();

		

		map.put("USA", 150);
//		map.put("China", 350);
//		map.put("Nepal", 25);
//		map.put("UK", 200);
		// map.put("India", 325);
		map.display();
		
		map.put("Aus",100);
		map.put("Russia", 250);
		map.display();
	}

}
