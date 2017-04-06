package queue;

public class ArrayQueue {
    public static final int defaultSize = 100;
    private int n;
    private int[] data;

    private int pushIndex = 0;
    private int pullIndex = -1;
    public ArrayQueue() {
	this(defaultSize);
    }
    public ArrayQueue(int n) {
	this.n = n;
	data = new int[n];
    }
    public int enqueueElement(int e) {
	if(getSize() >= n) {
	    System.out.println("Queue is full");
	    return -1;
	}
	
	data[pushIndex] = e;
	pushIndex = (pushIndex+1) % n;
	if(pullIndex == -1)
	    pullIndex++;
	System.out.println("inserted successfully");
	return 0;
    }
    public int dequeElement() {
	if(getSize() == 0) {
	    System.out.println("Queue is empty");
	    return -1;
	}
	int e = data[pullIndex];
	pullIndex = (pullIndex+1) % n;
	if(pullIndex == pushIndex) {
	    pushIndex = 0;
	    pullIndex = -1;
	}
	return e;
    }
    public void printQueue() {
	int index = pullIndex;
	while(getSize() != 0) {
	    index = (index+1) % n;
	}
    }
    public int getSize() {
	if(pushIndex == pullIndex)
	    return n;
	if(pullIndex == -1)
	    return 0;
	return (pushIndex + n - pullIndex) % n;
    }
    public String toString() {
	int size = getSize();
	if(size == 0)
	    System.out.println("Empty Queue");
	StringBuilder sb = new StringBuilder();
	int tempIndex = pullIndex;
	while(size-- > 0) {
	    sb.append(data[tempIndex] + " ");
	    tempIndex = (tempIndex+n+1) % n;
	}
	return sb.toString();
    }
}
