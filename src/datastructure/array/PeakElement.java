package datastructure.array;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 */
public class PeakElement {

    public static void main(String [] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println("peak element index::"+peakElement(0, arr.length-1,arr));
    }
    private static int peakElement(int left, int right, int [] arr) {
        int mid = (left+right)/2;
        if ((mid == 0 || arr[mid - 1] <= arr[mid])
                && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid]))
            return mid;
        if(mid>0 && arr[mid-1]>arr[mid])
            return peakElement(left,mid-1,arr);
        else
            return peakElement(mid+1,right,arr);
    }
}
