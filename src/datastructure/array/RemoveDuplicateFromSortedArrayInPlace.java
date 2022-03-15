package datastructure.array;

public class RemoveDuplicateFromSortedArrayInPlace {
    public static void main(String []args) {
        int[] nums = {0,0,1,1,1,2,2,2,3,3,4};
        int result = removeDuplicates(nums);
        for(int i=0;i<result;i++) {
            System.out.print(nums[i]+" ");
        }

    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length==1)
            return 1;
        int j=0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]!=nums[i+1]) {
                nums[j]=nums[i];
                j++;
            }
        }
        nums[j]=nums[nums.length-1];
        return ++j;
    }
}
