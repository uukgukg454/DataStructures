package datastructure.array;

import java.util.Arrays;

public class CountTriplet {

    public static void main(String [] args) {
        int[] arr = {14,3,6,8,11,16}; //{1, 5, 3, 2};
        int n = arr.length;
        System.out.println(count(arr,n));
    }

    /**
     *Given an array of distinct integers.
     * The task is to count all the triplets such that sum of two elements equals the third element.
     */
    public static int count(int [] arr, int n) {
        Arrays.sort(arr);
        int ans=0;
        for(int i=n-1;i>=0;i--) {
            int k = i-1;
            int j = 0;
            while(j<k) {
                if(arr[j]+arr[k]==arr[i]) {
                    ans++;
                    k--;
                    j++;
                }else if(arr[j]+arr[k]>arr[i]) {
                    k--;
                }else {
                    j++;
                }
            }
        }
        return ans;
    }

}
