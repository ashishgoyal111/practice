package queue;

import queue.ArrayQueue;

public class QueueUsage {
    public static void main(String[] args) {
	ArrayQueue data = new ArrayQueue(4);
	data.enqueueElement(1);
	System.out.println(data.toString());
	data.enqueueElement(2);
	System.out.println(data.toString());
	data.enqueueElement(3);
	System.out.println(data.toString());
	data.enqueueElement(4);
	System.out.println(data.toString());
	data.enqueueElement(5);
	System.out.println(data.toString());
	data.enqueueElement(6);
	System.out.println(data.toString());
	
	System.out.println(data.dequeElement());
	System.out.println(data.toString());
	System.out.println(data.dequeElement());
	System.out.println(data.toString());
	System.out.println(data.dequeElement());
	System.out.println(data.toString());
	System.out.println(data.dequeElement());
	System.out.println(data.toString());
	System.out.println(data.dequeElement());
    }
}
