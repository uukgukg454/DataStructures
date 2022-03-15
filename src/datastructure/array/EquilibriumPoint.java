package datastructure.array;

public class EquilibriumPoint {

    public static void main(String [] args) {
        long[] arr = {1,3,5,2,2};
        System.out.println(equilibriumPoint(arr, arr.length));
    }

    /**
     *Given an array A of n positive numbers.
     * The task is to find the first Equilibium Point in the array.
     Equilibrium Point in an array is a position such that the
     sum of elements before it is equal to the sum of elements after it.
     */
    public static int equilibriumPoint(long[] arr, int n) {
        long arrSum = 0;
        for(int i=0;i<n;i++) {
            arrSum += arr[i];
        }
        long leftSum =0;
        int equilibriumIndex =-1;
        for(int i=0;i<n;i++) {
            arrSum= arrSum-arr[i];
            if(leftSum==arrSum) {
                equilibriumIndex =  i+1;
                break;
            }
            leftSum += arr[i];
        }
        return equilibriumIndex;
    }
}
