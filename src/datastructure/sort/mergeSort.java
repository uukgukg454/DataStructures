package datastructure.sort;

public class mergeSort {

    public static void main(String [] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int n= arr.length;
        int left = 0;
        int right =n-1;
        System.out.println("original array:");
        for(int i: arr)
            System.out.print(i+" ");
        sort(arr,left,right);
        System.out.println("\nsorted array:");
        for(int i: arr)
            System.out.print(i+" ");
    }

    public static void sort(int [] arr, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            sort(arr,left,mid);
            sort(arr,mid+1,right);
            merge(arr, left,mid,right);
        }
    }

    public static void merge(int [] arr, int left, int mid, int right) {
        int leftSubArrSize = mid-left+1;
        int rightSubArrSize = right-mid;
        int [] leftSubArr = new int [leftSubArrSize];
        int [] rightSubArr = new int [rightSubArrSize];

        for(int i=0;i<leftSubArrSize;i++) {
            leftSubArr[i]= arr[left+i];
        }
        for(int j=0;j<rightSubArrSize;j++) {
            rightSubArr[j]= arr[mid+1+j];
        }
        int i=0, j=0;
        int k =left;

        while(i<leftSubArrSize && j<rightSubArrSize) {
            if(leftSubArr[i]>rightSubArr[j]) {
                arr[k]=rightSubArr[j];
                j++;
            } else {
                arr[k]= leftSubArr[i];
                i++;
            }
            k++;
        }
        while(i<leftSubArrSize) {
            arr[k]= leftSubArr[i];
            i++;
            k++;
        }

        while(j<rightSubArrSize) {
            arr[k]= rightSubArr[j];
            j++;
            k++;
        }
    }
}
