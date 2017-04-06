package stack;
import stack.ArrayStack;

public class NextGreaterElementInArray {
    public static int[] nextGreaterElement(int[] arr) {
	int n = arr.length;
	int[] output = new int[n];
	for(int i=0; i<n; i++) {
	    output[i] = -1;
	}
	ArrayStack data = new ArrayStack(n);
	for(int i=0; i<n; i++) {
	    if(data.isEmpty()) {
		data.pushElement(i);
		continue;
	    }
	    int cur = arr[i];
	    while(!data.isEmpty() && cur > arr[data.getTopElement()]) {
		int index = data.popElement();
		output[index] = cur;
	    }
	    data.pushElement(i);
	}
	output[n-1] = -1;
	return output;
    }
    
    public static int[] nextGreaterElementByReverse(int[] arr) {
	int n = arr.length;
	int[] output = new int[n];
	for(int i=0; i<n; i++) {
	    output[i] = -1;
	}
	ArrayStack data = new ArrayStack(n);
	for(int i=n-1; i>=0; i--) {
	    if(data.isEmpty()) {
		data.pushElement(i);
		continue;
	    }
	    int cur = arr[i];
	    while(!data.isEmpty() && cur > arr[data.getTopElement()]) {
		data.popElement();
	    }
	    if(!data.isEmpty())
		output[i] = arr[data.getTopElement()];
	    data.pushElement(i);
	}
	output[n-1] = -1;
	return output;
    }
}
