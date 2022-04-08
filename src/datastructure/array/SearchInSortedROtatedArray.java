package datastructure.array;

public class SearchInSortedROtatedArray {

    public static void main(String []args) {
        int [] arr= {4,5,6,7,0,1,2};
        int target =0;
        System.out.println("target index is:"+search(arr,target));
    }
    static int search(int[] nums, int target) {
        int l =0;
        int r= nums.length -1;
        int pivotElement = findPivotElement(nums,l,r);
        if(pivotElement ==-1) //array is not rotated.
            return binarySearch(nums,l,r, target);
        if(nums[pivotElement]==target)
            return pivotElement;
        if (nums[0]<=target) {
            return binarySearch(nums,l,pivotElement-1, target);
        } else
            return binarySearch(nums,pivotElement+1, r, target);
    }

   static int binarySearch(int []nums, int l, int r, int target) {
        if(l>r)
            return -1;
        int mid = l+(r-l)/2;
        if(nums[mid]==target)
            return mid;
        if(target>=nums[mid])
            return binarySearch(nums,mid+1,r, target);
        else
            return binarySearch(nums,l,mid-1,target);
    }

    static int findPivotElement(int []nums, int l, int r) {
        if(l>r)
            return -1;
        if(l==r)
            return l;
        int mid = l+(r-l)/2;
        if(mid<r && nums[mid]>nums[mid+1])
            return mid;
        if(mid-1>l && nums[mid-1]>nums[mid])
            return mid-1;
        if(nums[l]>=nums[mid])
            return findPivotElement(nums,l,mid-1);
        else
            return findPivotElement(nums,mid+1,r);
    }
}
