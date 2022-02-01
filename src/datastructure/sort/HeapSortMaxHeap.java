package datastructure.sort;

public class HeapSortMaxHeap {
    public static void main(String [] args) {
        int [] arr = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int n =arr.length;
        sortAscendingOrder(arr,n);
        for(int i: arr) {
            System.out.print(i+" ");
        }
    }

    static void sortAscendingOrder(int [] arr, int n) {
        build(arr,n);
        for(int i=n-1;i>=0;i--) {
            int temp = arr[0];
            arr[0]= arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }

    static void build(int [] arr, int n) {
        int size = (n/2)-1;
        for(int i=size;i>=0;i--) {
            heapify(arr,n, i);
        }
    }

    static void heapify(int [] arr, int n, int i) {
        int largest =i;
        int left =(2*i)+1;
        int right = (2*i)+2;
        if(left<n && arr[left]>arr[largest]) {
            largest =left;
        }
        if(right<n && arr[right]>arr[largest]) {
            largest =right;
        }
        if(largest !=i) {
            int temp = arr[i];
            arr[i]= arr[largest];
            arr[largest] = temp;
            heapify(arr,n, largest);
        }
    }
}
