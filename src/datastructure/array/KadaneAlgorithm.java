package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KadaneAlgorithm {

    public static void main(String [] args) {
        int [] arr = {1,2,3,-2,5};
        int n = arr.length;
        System.out.println(contiguousSubArrayMaxSum(arr,n));
        System.out.println(contiguousSubArrayIndices(arr,n));
    }

    public static int contiguousSubArrayMaxSum(int [] arr, int n) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            currSum= currSum+arr[i];
            if(currSum>maxSum) {
                maxSum= currSum;
            }
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }

    public static List<Integer> contiguousSubArrayIndices(int [] arr, int n) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start =0;
        int end =0;
        int s =0;
        for(int i=0;i<n;i++) {
            currSum= currSum+arr[i];
            if(currSum>maxSum) {
                maxSum= currSum;
                start=s;
                end =i;
            }
            if(currSum<0){
                currSum=0;
                s=i+1;
            }
        }
        return Arrays.asList(start,end);
    }
}
