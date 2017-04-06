package stack;

import javax.script.ScriptException;
import stack.NextGreaterElementInArray;

public class StackUsage {

    public static void main(String[] args) throws ScriptException
    {
	// TODO Auto-generated method stub
	int[] arr = {4, 5, 2, 25};
	int[] output = NextGreaterElementInArray.nextGreaterElement(arr);
	for (int i : output) {
	    System.out.println(i);
	}
	output = NextGreaterElementInArray.nextGreaterElementByReverse(arr);
	for (int i : output) {
	    System.out.println(i);
	}

    }
}
