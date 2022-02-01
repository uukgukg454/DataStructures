package datastructure.array;

import java.util.ArrayList;

public class SubArrayWithGIvenSum {

    public static void main(String [] args) {
        int [] arr= {11,2,1,5,4,8};
        int sum = 17;
        int n= arr.length;
        System.out.println(subarraySum(arr,n,sum));
    }

    /**
    Given an unsorted array A of size N that contains only non-negative integers,
    find a continuous sub-array which adds to a given number S.
     **/
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>(2);
        int startIndex = 0;
        int currSum = 0;
        int i;
        for(i=0;i<n;i++) {
            currSum=currSum+arr[i];
            while(currSum>s){
                currSum=currSum-arr[startIndex];
                startIndex++;
            }
            if(currSum==s){
                result.add(++startIndex);
                result.add(++i);
                break;
            }
        }
        if(result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }
}
