package datastructure.array;

public class MinOfJumpsToReachEnd {

    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        System.out.println("canJump:"+ canJump(nums));
    }

    private static  boolean canJump(int[] nums) {
        int n = nums.length;
        int [] minJumpDpArr = new int[n];
        minJumpDpArr[0]=0;
        for(int i=1;i<n;i++) {
            minJumpDpArr[i]= Integer.MAX_VALUE;
            for(int j=0;j<i;j++) {
                if(i<=j+nums[j] && minJumpDpArr[j] != Integer.MAX_VALUE) {
                    minJumpDpArr[i]= Math.min(minJumpDpArr[i],minJumpDpArr[j]+1);
                }
            }
        }
        return minJumpDpArr[n - 1] != Integer.MAX_VALUE;
    }
}
