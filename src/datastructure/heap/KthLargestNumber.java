package datastructure.heap;

public class KthLargestNumber {
    public static void main(String [] args) {
        int [] arr = {3,2,1,5,6,4};
        int k =3;
        System.out.println("kth largest element is:"+findKthLargest(arr,k));

    }
    static int findKthLargest(int[] nums, int k) {
        int heapSize =0;
        int [] heap = new int[k];
        for(int i=0;i<nums.length;i++) {
            if(heapSize< k -1) {
                heap[heapSize]=nums[i];
                heapSize++;
            } else if(heapSize== k -1) {
                heap[heapSize]=nums[i];
                heapSize++;
                minHeap(heap,heapSize);
            } else {
                if(nums[i]>heap[0]) {
                    heap[0]=nums[i];
                    heapify(heap,0,heapSize);
                }
            }
        }
        return heap[0];
    }

    static  void minHeap(int [] heap, int heapSize )
    {
        int size= (heapSize/2);
        for(int i=size-1;i>=0;i--)
        {
            heapify(heap, i, heapSize);
        }
    }
    static  void heapify(int []heap, int i, int heapSize) {
        int smallest =i;
        int left = getLeftChild(i);
        int right = getRightChild(i);
        if(left<heapSize && heap[left]<heap[smallest])
            smallest = left;
        if(right<heapSize && heap[right]<heap[smallest])
            smallest = right;
        if(smallest !=i) {
            int temp = heap[smallest];
            heap[smallest]=heap[i];
            heap[i]=temp;
            heapify(heap,smallest,heapSize);
        }
    }

    private  static int getParent(int pos) {
        return (pos-1)/2;
    }

    private static int getLeftChild(int pos) {
        return (2*pos)+1;
    }

    private static int getRightChild(int pos) {
        return (2*pos)+2;
    }
}
