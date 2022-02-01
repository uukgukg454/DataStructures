package datastructure.heap;

public class BuildMinHeapFromArray {
    public static void main(String [] args) {
        int [] arr = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        build(arr);
        for(int i: arr) {
            System.out.print(i+" ");
        }
    }

    static void build(int [] arr) {
        int n = arr.length;
        int size = (arr.length/2)-1;
        for(int i=size;i>=0;i--) {
            heapify(arr,n, i);
        }
    }

    static void heapify(int [] arr, int n, int i) {
        int smallest =i;
        int left =(2*i)+1;
        int right = (2*i)+2;
        if(left<n && arr[left]<arr[smallest]) {
            smallest =left;
        }
        if(right<n && arr[right]<arr[smallest]) {
            smallest =right;
        }
        if(smallest !=i) {
            int temp = arr[i];
            arr[i]= arr[smallest];
            arr[smallest] = temp;
            heapify(arr,n, smallest);
        }
    }
}
