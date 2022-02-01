package datastructure.array;

public class MaxIndex {

    public static void main(String [] args) {
        int arr[] = { 34,8,10,3,2,80,30,33,1};
        System.out.println(maxIndexDiff(arr));
    }

    /**Given an array A[] of N positive integers.
     * The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.
     */
    public static int maxIndexDiff(int [] arr) {
        int n = arr.length;
        int [] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) {
            rightMax[i]= Math.max(rightMax[i+1],arr[i]);
        }
        int maxDiff = Integer.MIN_VALUE;
        int i=0;
        int j=0;
        while(i<n && j<n) {
            if(rightMax[j]>=arr[i]) {
                maxDiff = Math.max(maxDiff,j-i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
}
