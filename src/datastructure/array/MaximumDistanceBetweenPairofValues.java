package datastructure.array;

/**
 * You are given two non-increasing 0-indexed integer arrays nums1 and nums2.
 * A pair of indices (i, j), where 0 <= i < nums1.length
 * and 0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j].
 * The distance of the pair is j - i.
 * Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.
 * An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.
 */

public class MaximumDistanceBetweenPairofValues {

    public static void main(String [] args) {
        int []nums1 = {55,30,5,4,2}, nums2 = {100,20,10,10,5};
        System.out.println("max distance between pairs: "+ maxDistance(nums1, nums2));
    }
    private static  int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int maxIndexDiff = 0;
        int i=0,j=0;
        while(i<n1 && j<n2) {
            if(nums1[i]>nums2[j]) {
                i++;
            } else {
                maxIndexDiff = Math.max(maxIndexDiff,j-i);
                j++;
            }
        }
        return maxIndexDiff;
    }
}
