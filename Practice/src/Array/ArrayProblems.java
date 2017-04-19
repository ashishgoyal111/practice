package Array;

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
    public static boolean isArraySorted(int[] a) {
	for(int i=0; i<a.length-1;) {
	    if(a[i] > a[i++])
		return false;
	}
	return true;
    }
    public static float medianOfTwoSortedArrays(int[] a, int[] b) {
	int n = a.length;
	if(!isArraySorted(a) || !isArraySorted(b))
	{
	    System.out.println("One of the two arrays is not sorted");
	    return -1;
	}
	int j, k, prev, current;
	j = k = 0;
	prev = current = 0;
	for(int i=0; i<=n; i++) {
	    if(j == n) {
		prev = current;
		current = b[0];
		break;
	    }
	    if(k == n) {
		prev = current;
		current = a[0];
		break;
	    }
	    if(a[j] < b[k]) {
		prev = current;
		current = a[j];
		j++;
	    }
	    else {
		prev = current;
		current = b[k];
		k++;
	    }
	}
	return (prev + current)/(float)2.0;
    }

    public static double medianOfTwoSortedArraysRecusrsive(int[] a, int[] b) {
	int n = a.length;
	if(!isArraySorted(a) || !isArraySorted(b))
	{
	    System.out.println("One of the two arrays is not sorted");
	    return -1;
	}
	return medianOfTwoSortedArrays(a, 0, n-1, b, 0, n-1);
    }

    public static int max(int... a) {
	int n = a.length;
	int max = a[0];
	for(int i=1; i<n; i++) {
	    if(a[i] > max)
		max = a[i];
	}
	return max;
    }
    public static int min(int... a) {
	int n = a.length;
	int min = a[0];
	for(int i=1; i<n; i++) {
	    if(a[i] < min)
		min = a[i];
	}
	return min;
    }
    public static double medianOfTwoSortedArrays(int[] a, int startA, int endA, int[] b, int startB, int endB) {
	System.out.println("startA : " + startA + " endA : " + endA +" startB : " + startB + " endB : " + endB);
	int n = endA - startA + 1;
	if(n == 2) {
	    return (max(a[startA], b[startB]) + min(a[endA], b[endB]))/2.0;
	}
	int medianA, medianB, medianIndexA, medianIndexB;
	medianIndexA = startA + ((endA - startA) / 2);
	System.out.println("medianIndexA : " + medianIndexA);
	medianA = a[medianIndexA];
	medianIndexB = startB + ((endB - startB + 1) / 2);
	System.out.println("medianIndexB : " + medianIndexB);
	medianB = b[medianIndexB];
//	if(medianIndexA == 4 && medianIndexB == 1)
//	    return -1;
	if(medianA < medianB) {
	    System.out.println("A is lesser than B");
	    return medianOfTwoSortedArrays(a, medianIndexA, endA, b, startB, medianIndexB);
	}
	else {
	    System.out.println("B is lesser than A");
	    return medianOfTwoSortedArrays(a, startA, medianIndexA, b, medianIndexB, endB);
	}
    }
    public static int[] dutchNationalFlagProblem(int[] input) {
	int n = input.length;
	int i, k;
	i = 0;
	k = n-1;
	for(int l = 0; l <= k;) {
	    if(input[l] == 0) {
		int temp = input[i];
		input[i] = input[l];
		input[l] = temp;
		l++;
		i++;
		continue;
	    }
	    if(input[l] == 1) {
		l++;
		continue;
	    }
	    if(input[l] == 2) {
		int temp = input[k];
		input[k] = input[l];
		input[l] = temp;
		k--;
		continue;
	    }
	}
	return input;
    }
    public static void printArray(int[] a) {
	for(int i=0; i<a.length; i++) {
	    System.out.print(a[i] + ",");
	}
	System.out.println();
    }
    public static int[] smallerElementsOnRightSide(int[] a) {
	
	return a;
    }
    public static int minimumStepsToReachEnd(int[] a) {
	int n = a.length;
	if(n == 0 || a[0] == 0)
	    return 2*n;
	int[] min = new int[n];
	min[0] = 0;
	for(int i=1; i<n; i++) {
	    min[i] = n;
	}
	for(int i=0; i<n; i++) {
	    int temp = min[i] + 1;
	    int tempIndex = i + a[i];
	    if(tempIndex >= n)
		tempIndex = n-1;
	    if(temp < min[tempIndex]) {
		min[tempIndex] = temp;
	    }
	}
	return min[n-1];
    }
}
