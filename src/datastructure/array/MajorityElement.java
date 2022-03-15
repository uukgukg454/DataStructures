package datastructure.array;

public class MajorityElement {

    public static void main(String [] args) {
        int [] arr ={3,3,1,2,3,3,4,3,5};
        int n = arr.length;
        int candidate = findCandidate(arr, n);
        System.out.println(isMajority(arr, n, candidate));
    }

    static int findCandidate(int[] arr, int size)
    {
        int majorityElementIndex =0;
        int majorityElementCount =1;

        for(int i=1;i<size;i++) {
            if(arr[majorityElementIndex]==arr[i]) {
                majorityElementCount++;
            }else {
                majorityElementCount--;
            }
            if(majorityElementCount==0) {
                majorityElementIndex=i;
                majorityElementCount =1;
            }
        }
        return arr[majorityElementIndex];
    }

    static int isMajority(int [] arr, int size, int candidate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == candidate)
                count++;
        }
        if (count > size / 2)
            return candidate;
        else
            return -1;
    }
}
