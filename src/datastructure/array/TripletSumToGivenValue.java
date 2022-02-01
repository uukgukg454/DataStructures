package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;

public class TripletSumToGivenValue {
    public static void main(String [] args) {
        int [] arr = {12, 3, 4, 1, 6, 9};
        int sum = 24;
        System.out.println(findTriplet(arr,sum));
    }

    public static ArrayList<Integer> findTriplet(int [] arr, int sum) {
        ArrayList<Integer> result = new ArrayList<>(3);
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++) {
            int j= n-1;
            int k =i+1;
            while(k<j) {
                if(arr[i]+arr[j]+arr[k]==sum) {
                    result.add(arr[i]);
                    result.add(arr[j]);
                    result.add(arr[k]);
                    break;
                } else if(arr[i]+arr[j]+arr[k]>sum) {
                    j--;
                }else {
                    k++;
                }
            }
        }
        if(result.isEmpty()) {
            result.add(-1);
        }
        return result;

    }
}
