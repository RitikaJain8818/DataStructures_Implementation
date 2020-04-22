package Lecture11;

import Lecture10.QueueUsingArrays;

public class DyanmicQueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		QueueUsingArrays queue = new DynamicQueue(5);
		for (int i = 1; i <= 5; i++) {
			queue.enqueue(i * 10);
			displayQueueInfo(queue);
		}
		// stack.push(60);
		queue.dequeue();
		displayQueueInfo(queue);
		queue.dequeue();
		displayQueueInfo(queue);
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(90);
		displayQueueInfo(queue);
		while (!queue.isEmpty()) {
			displayQueueInfo(queue);
			queue.dequeue();
		}
		// stack.pop();
		//queue.dequeue();

	}

	public static void displayQueueInfo(QueueUsingArrays queue) throws Exception {
		System.out.println("*****************************");
		queue.display();
		System.out.println("Size-" + queue.size());
		System.out.println("Front-" + queue.front());
		System.out.println("*****************************");
	}

}
