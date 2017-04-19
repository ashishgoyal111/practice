package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FleetGreyOrange {

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
	int n= in.nextInt();
	int[] input = new int[n]; 
	for(int i=0; i<n; i++) {
	    input[i] = in.nextInt();
	}
	int[] output = chooseFleets(input);
	for(int i=0; i<n; i++) {
	    System.out.println(output[i]);
	}
	in.close();
    }
    
    /*
     * Complete the function below.
     */

        static int[] chooseFleets(int[] wheels) {
            int[] result = new int[wheels.length];
            for(int i=0; i<wheels.length; i++) {
                result[i] = 0;
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<wheels.length; i++) {
                int n = wheels[i];
                if(n < list.size())
                    continue;
            }
            return result;
        }
        static int countNumber(int n) {
            if(n%2 != 0)
        	return 0;
            if(n < 0)
                return -1;
            if(n == 0)
                return 0;
            if(n == 2)
                return 1;
            if(n == 4)
                return 2;
            int count1 , count2, tempcount1, tempcount2;
            tempcount1 =  countNumber(n-2);
            if(tempcount1 == -1)
                count1 = 0;
            else
                count1 = 1 + tempcount1;
            tempcount2 =  countNumber(n-4);
            if(tempcount2 == -1)
                count2 = 0;
            else
                count2 = 1 + tempcount2;
            System.out.println("count1 : " + count1 + " count2 : " + count2);
            return count1 + count2;
        }



}
