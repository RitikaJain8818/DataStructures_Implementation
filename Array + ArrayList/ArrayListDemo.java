package Lecture5;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list);

		System.out.println(list.size());

		list.add(10);
		System.out.println(list);

		System.out.println(list.size());
		
		list.add(20);
		System.out.println(list);

		System.out.println(list.size());
		
		list.add(30);
		System.out.println(list);

		System.out.println(list.size());
		
		list.add(40);
		System.out.println(list);

		System.out.println(list.size());
		
		list.add(50);
		System.out.println(list);

		System.out.println(list.size());
		
		System.out.println(list.get(4));
		//System.out.println(list.get(6));
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

		list.remove(1);
		System.out.println(list);
		System.out.println(list.size());
		
	
		list.set(3, 70);
		System.out.println(list);
		System.out.println(list.size());

	}

}
