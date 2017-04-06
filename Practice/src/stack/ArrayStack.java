package stack;

public class ArrayStack {
    int n;
    public static final int defaultSize = 100;
    int[] data;
    int index = -1;
    public ArrayStack() {
	this(defaultSize);
    }
    public ArrayStack(int n) {
	this.n = n;
	data = new int[n];
    }
    public void pushElement(int e) {
	if(index == n-1) {
	    System.out.println("Stack is full");
	    return;
	}
	System.out.println(e + " pushed to stack");
	data[++index] = e;
    }
    public int popElement() {
	if(index == -1) {
	    return -1;
	}
	return data[index--];
    }
    public int getSize() {
	return index+1;
    }
    public boolean isEmpty() {
	return index == -1;
    }
    public int getTopElement() {
	if(index == -1) {
	    return -1;
	}
	return data[index];
    }
    public String toString() {
	StringBuilder sb = new StringBuilder();
	int tempIndex = index;
	while(tempIndex != -1) {
	    sb.append(data[tempIndex--] + " ");
	}
	return sb.toString();
    }
}
