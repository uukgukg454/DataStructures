package datastructure.array;

public class FirstAndLastInSortedArray {
    public static void main (String []args) {
        int [] res = new int[2];
        int [] nums = {5,7,7,8,8,10};
        int target =8;
        int left= 0;
        int right= nums.length-1;
        res[0] =searchFirst(left,right,nums,target);
        res[1] = searchLast(left,right,nums,target);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    private static int searchFirst(int left, int right, int []nums,int target) {
        if(right>=left) {
            int mid = (left+right)/2;
            if((mid==0 || target > nums[mid-1]) && nums[mid]==target) {
                return mid;
            }
            if(nums[mid]<target) {
                return searchFirst(mid+1,right,nums,target);
            }
            return searchFirst(left,mid-1,nums,target);
        }
        return -1;
    }

    private static int searchLast(int left, int right, int []nums,int target) {
        if(right>=left) {
            int mid = (left+right)/2;
            if((mid==nums.length-1 || target < nums[mid+1]) && nums[mid]==target) {
                return mid;
            }
            if(nums[mid]>target) {
                return searchLast(left,mid-1,nums,target);
            }
            return searchLast(mid+1,right,nums,target);
        }
        return -1;
    }
}
