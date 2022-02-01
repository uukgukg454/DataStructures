package datastructure.array;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {

    public static void main(String [] args) {
        int [] arr= {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(arr,arr.length));
    }
    static int maxLen(int [] arr, int n)
    {
        HashMap<Long,Integer> hm = new HashMap<>();
        int maxLength =0; long sum=0;
        for(int i=0;i<n;i++) {
            sum +=arr[i];
            if (arr[i] == 0 && maxLength == 0)
                maxLength = 1;
            if(sum==0)
                maxLength = i+1;

            Integer index = hm.get(sum);
            if(index==null) {
                hm.put(sum,i);
            } else {
                maxLength = Math.max(maxLength, i-index);
            }
        }
        return maxLength;
    }
}
