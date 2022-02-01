package datastructure.array;

import java.util.ArrayList;

public class ReverseArrayInGroups {

    public static void main(String [] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        int k =3;
        int n =arr.size();
        reverseInGroups(arr,n,k);
        for(int i: arr) {
            System.out.print(i+" ");
        }
    }

    /**
     *Given an array arr[] of positive integers of size N.
     * Reverse every sub-array group of size K.
     */
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int temp=0;
        for(int i=0;i<n;i+=k) {
            int left =i;
            int right = Math.min(i+k-1, n-1);
            while (left < right)
            {
                temp=arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right,temp);
                left+=1;
                right-=1;
            }
        }
    }
}
