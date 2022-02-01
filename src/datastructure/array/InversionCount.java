package datastructure.array;

public class InversionCount {

    public static void main(String [] args) {
        long []arr = {2, 4, 1, 3, 5};
        int n= arr.length;
        int left = 0;
        int right =n-1;
        System.out.println(sort(arr, left,right));
    }

    /**
     *Given an array of integers. Find the Inversion Count in the array.
     * Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
     * If array is already sorted then the inversion count is 0.
     * If an array is sorted in the reverse order then the inversion count is the maximum.
     * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     */
    private static long sort(long [] arr, int left, int right) {
        long count =0;
        if(left<right) {
            int mid = (left+right)/2;
            count += sort(arr,left,mid);
            count += sort(arr,mid+1,right);
            count +=  merge(arr, left,mid,right);
        }
        return count;
    }

    private static long merge(long [] arr, int left, int mid, int right) {
        int leftSubArrSize = mid - left + 1;
        int rightSubArrSize = right - mid;
        long[] leftSubArr = new long[leftSubArrSize];
        long[] rightSubArr = new long[rightSubArrSize];

        for (int i = 0; i < leftSubArrSize; i++) {
            leftSubArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightSubArrSize; j++) {
            rightSubArr[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        long swap = 0;

        while (i < leftSubArrSize && j < rightSubArrSize) {
            if (leftSubArr[i] > rightSubArr[j]) {
                arr[k] = rightSubArr[j];
                j++;
                swap = swap + leftSubArrSize - i;
            } else {
                arr[k] = leftSubArr[i];
                i++;
            }
            k++;
        }
        while (i < leftSubArrSize) {
            arr[k] = leftSubArr[i];
            i++;
            k++;
        }

        while (j < rightSubArrSize) {
            arr[k] = rightSubArr[j];
            j++;
            k++;
        }
        return swap;
    }
}
