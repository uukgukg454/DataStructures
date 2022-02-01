package datastructure.array;

public class MissingAndRepeatingElement {

    public static void main(String [] args) {
        int [] arr = {1,3,3};
        int n =arr.length;
        int [] result = findTwoElement(arr, n);
        for(int i: result) {
            System.out.print(i+" ");
        }
    }

    /**
     *Given an unsorted array Arr of size N of positive integers.
     * One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array.
     * Find these two numbers.
     */
    static int[] findTwoElement(int arr[], int n) {
        int [] result = new int[2];
        int missingNumber =0;
        int duplicateNumber =0;
        for(int i=0;i<n;i++) {
            int index= Math.abs(arr[i])-1;
            if(arr[index]<0){
                duplicateNumber = Math.abs(arr[i]);
            } else {
                arr[index]= -arr[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                missingNumber = i + 1;
        }
        result[0]=duplicateNumber;
        result[1]=missingNumber;
        return result;
    }
}
