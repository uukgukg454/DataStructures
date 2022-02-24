package datastructure.array;

public class WaterTrappingProblem {
    public static void main(String args []) {
        int [] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("total water trapped:"+totalWaterStoredWthTwoArrays(arr));
        System.out.println("total water trapped:"+totalWaterStoredWthNoExtraSpace(arr));
    }

    static int totalWaterStoredWthTwoArrays(int [] arr) {
        int result= 0;
        int n= arr.length;
        int [] left = new int [n];
        int [] right = new int [n];
        left[0]= 0;
        right[n-1]= 0;
        int leftMax =arr[0];
        for(int i=1;i<n;i++) {
            left[i] = leftMax;
            if(arr[i]>leftMax) {
                leftMax = arr[i];
            }
        }
        int rightMax = arr[n-1];
        for(int i=n-2;i>=0;i--) {
            right[i] = rightMax;
            if(arr[i]> rightMax) {
                rightMax = arr[i];
            }
        }
        for(int i=1;i<n-1;i++) {
            int maxBoundary = Math.min(left[i],right[i]);
            if(maxBoundary-arr[i] >0)
                result = result + maxBoundary-arr[i];
        }
        return result;
    }

    static int totalWaterStoredWthNoExtraSpace(int [] arr) {
        int n =arr.length;
        int result =0;
        int low= 0;
        int high= n-1;
        int leftMax= 0;
        int rightMax =0;
        while(low<=high) {
            if(arr[low]<arr[high]) {
                if(arr[low]>leftMax) {
                    leftMax = arr[low];
                } else {
                    result= result+(leftMax-arr[low]);
                }
                low++;
            } else {
                if(arr[high]>rightMax) {
                    rightMax = arr[high];
                } else {
                    result = result+(rightMax-arr[high]);
                }
                high--;
            }
        }
        return result;
    }
}
