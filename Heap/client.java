package Lecture16;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Heap<Integer> heap = new Heap<>();
//		heap.add(35);
//		heap.add(30);
//		heap.add(25);
//		heap.add(20);
//		heap.add(15);
//
//		heap.add(10);
//		heap.add(5);
//		heap.add(8);
//		heap.add(12);
//		heap.display();
//		System.out.println("*******************");
//		heap.add(22);
//		heap.display();
//
//		System.out.println("*******************");
//		heap.remove();
//		heap.display();

//		Heap<Student> heap = new Heap();
//		heap.add(new Student(200, 8, "A"));
//		heap.add(new Student(500, 5, "B"));
//		heap.add(new Student(700, 3, "C"));
//		heap.add(new Student(100, 9, "D"));
//		heap.add(new Student(900, 1, "E"));
//		heap.add(new Student(800, 2, "F"));
//		heap.add(new Student(600, 4, "G"));
//		heap.add(new Student(300, 7, "H"));
//		heap.add(new Student(400, 6, "I"));
//		
//		Student[] students = new Student[9];
//		students[0] = new Student(200, 8, "A");
//		students[1] = new Student(500, 5, "B");
//		students[2] = new Student(700, 3, "C");
//		students[3] = new Student(100, 9, "D");
//		students[4] = new Student(900, 1, "E");
//		students[5] = new Student(800, 2, "F");
//		students[6] = new Student(600, 4, "G");
//		students[7] = new Student(300, 7, "H");
//		students[8] = new Student(400, 6, "I");
//
//		Heap<Student> heap = new Heap<>(students, false);
//		heap.display();

		Integer[] arr = { 3, 7, 22, 45, 13, 21, 78, 47 };
		System.out.println(kthlargest(arr, 3));
	}

	private static class Student implements Comparable<Student> {
		int marks;
		int rank;
		String name;

		Student(int marks, int rank, String name) {
			this.marks = marks;
			this.rank = rank;
			this.name = name;
		}

		public String toString() {
			return "{R=" + this.rank + ", M=" + this.marks + ", Name=" + this.name + "}";
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.marks - o.marks;
		}
	}

	public static int kthlargest(Integer[] arr, int k) {

		Heap<Integer> heap = new Heap<>(arr, false);
		for (int i = 1; i < k; i++) {
			heap.remove();
		}

		return heap.get();
	}

}
