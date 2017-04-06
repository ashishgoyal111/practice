package stack;

public class TwoStacksInAnArray {
    public static final int defaultSize = 100;
    int n;
    int[] data;
    int index1, index2;
    public TwoStacksInAnArray() {
	this(defaultSize);
    }
    public TwoStacksInAnArray(int n) {
	this.n = n;
	data = new int[n];
	index1 = -1;
	index2 = this.n;
    }
    public void push1(int e) {
	if(index1 + 1 == index2) {
	    System.out.println("Stacks full");
	    return;
	}
	data[++index1] = e;
	System.out.println("Successfully inserted");
    }
    public void push2(int e) {
	if(index1 + 1 == index2) {
	    System.out.println("Stacks full");
	    return;
	}
	data[--index2] = e;
	System.out.println("Successfully inserted");
    }
    public int pop1() {
	if(index1 ==  -1) {
	    System.out.println("No element in stack1");
	    return -1;
	}
	System.out.println("Successfully removed");
	return data[index1--];
    }
    public int pop2() {
	if(index2 ==  n) {
	    System.out.println("No element in stack2");
	    return -1;
	}
	System.out.println("Successfully removed");
	return data[index2++];
    }
    public int top1() {
	if(index1 ==  -1) {
	    System.out.println("No element in stack1");
	    return -1;
	}
	return data[index1];
    }
    public int top2() {
	if(index2 ==  n) {
	    System.out.println("No element in stack2");
	    return -1;
	}
	return data[index2];
    }
    public int size1() {
	return index1+1;
    }
    public int size2() {
	return n-index2;
    }
    public String toString(int x) {
	StringBuilder sb = new StringBuilder();
	int tempIndex;
	if(x == 1) {
	    tempIndex = index1;
	    while(tempIndex != -1) {
		sb.append(data[tempIndex--] + " ");
	    }
	    if(index1 == -1)
		sb.append("no element in stack1");
	}
	else if(x == 2) {
	    tempIndex = index2;
	    while(tempIndex != n) {
		sb.append(data[tempIndex++] + " ");
	    }
	    if(index2 == n)
		sb.append("no element in stack2");
	}
	return sb.toString();
    }
}
