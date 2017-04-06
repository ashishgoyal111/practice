package Array;
import stack.ArrayStack;

public class ArrayProblems {
    public static int searchElementInSortedAndRotatedArray(int[] input, int e, int l, int r) {
	int pivotIndex = findPivot(input, l ,r);
	if(e < input[pivotIndex])
	    return -1;
	if(e > input[0])
	    return binarySearch(input, e, l, pivotIndex);
	return binarySearch(input, e, pivotIndex, r);
    }
    
    public static int findPivot(int[] input, int l, int r) {
	if(l < 0 || r >= input.length || l > r)
	    return -1;
	int middle = l + (r-l)/2;
	if(input[middle] < input[middle-1] && input[middle] < input[middle + 1])
	    return middle;
	if(input[middle] > input[0]) {
	    return findPivot(input, middle, r);
	}
	return findPivot(input, l, middle);
    }
    public static int binarySearch(int[] input, int e, int l, int r) {
	if(l<0 || r>=input.length || l>r || (l == r && input[l] != e)) {
	    return -1;
	}
	int index = l + (r - l)/2;
	if(e == input[index])
	    return index;
	if(e > input[index])
	    return binarySearch(input, e, index+1, r);
	else
	    return binarySearch(input, e, l, index);
    }
    public static void rotationByJugglingAlgo(int[] arr, int d) {
	int n = arr.length;
	for(int i=0; i<gcdOf(arr.length, d); i++) {
	    int j = i;
	    int temp = arr[j];
	    while(1 != 0) {
		int k = j+d;
		if (k >= n) 
                    k = k - n;
                if (k == i) 
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
	}
    }
    public static int maxSumWithoutAdjacentElements(int[] input) {
	int n = input.length;
	int[] incl = new int[n];
	int[] excl = new int[n];
	incl[0] = input[0];
	excl[0] = 0;
	int maxByNow = 0;
	for(int i=1; i<n; i++) {
	    incl[i] = excl[i-1] + input[i];
	    excl[i] = max(incl[i-1], excl[i-1]);
	    if(incl[i] > maxByNow)
		maxByNow = incl[i];
	    if(excl[i] > maxByNow)
		maxByNow = excl[i];
	}
	return maxByNow;
    }
    /**An element is leader if it is greater than all the elements to its right side. 
     * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
     */
    public static void leaderInArray(int[] input) {
	int n = input.length;
	int maxTillNow = input[n-1];
	System.out.println(input[n-1] + " ");
	for(int i=n-1; i>=0; i--) {
	    if(input[i] > maxTillNow) {
		maxTillNow = input[i];
		System.out.println(maxTillNow + " ");
	    }
	}
    }
    public static int max(int a, int b) {
	if(a>b)
	    return a;
	return b;
    }
    public static int gcdOf(int a, int b) {
	if(a > b) {
	    int temp = b;
	    b = a;
	    a = temp;
	}
	int gcd = a;
	while(gcd >= 1) {
	    if(a%gcd == 0 && b%gcd ==0)
		break;
	    gcd--;
	}
	return gcd;
    }
}
