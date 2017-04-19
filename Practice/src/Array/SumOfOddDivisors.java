

package Array;

import java.util.HashMap;
import java.util.Scanner;

public class SumOfOddDivisors {

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
	int n= in.nextInt();
	int[] input = new int[n]; 
	for(int i=0; i<n; i++) {
	    input[i] = in.nextInt();
	}
	long output = countSum(input);
	System.out.println(output);
	in.close();
    }
    /*
     * Complete the function below.
     */

        static long countSum(int[] numbers) {
            long finalSum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<numbers.length; i++) {
                int n = numbers[i];
                if(!map.containsKey(n)) {
                    int sumOfOddDivisors = getSumOfOddDivisors(n);
                    map.put(n, sumOfOddDivisors);
                }
                finalSum += (map.get(n));
            }
            return finalSum;
        }

        static int getSumOfOddDivisors(int n) {
            if(n == 1)
        	return 1;
            int sum = 1;
            for(int i=3; i<=n/2; i = i+2) {
                if(n % i == 0) {
                    sum += i;
                }
            }
            if(n % 2 != 0) {
                sum += n;
            }
            return sum;
        }



}
