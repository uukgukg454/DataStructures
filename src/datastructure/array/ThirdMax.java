package datastructure.array;

/**
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 */
public class ThirdMax {

    public static void main(String[] args) {
        int [] arr = {2,2,3,1};
        System.out.println("third max is: "+thirdMax(arr));
    }

    private static int thirdMax(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        if(nums.length==2) {
            return Math.max(nums[0],nums[1]);
        }
        int f = nums[0];
        long s = Long.MIN_VALUE;
        long t = Long.MIN_VALUE;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=f && nums[i]!=s && nums[i]!=t) {
                if(nums[i]>f) {
                    t=s;
                    s=f;
                    f=nums[i];
                } else if(nums[i]>s) {
                    t=s;
                    s=nums[i];
                } else if(nums[i]>t) {
                    t=nums[i];
                }
            }
        }
        if(t==Long.MIN_VALUE)
            return f;
        else
            return Math.toIntExact(t);
    }
}
