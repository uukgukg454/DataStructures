package datastructure.array;

public class RearrangeArrayAlternatively {

    public static void main(String [] args) {
        int [] arr = {1,2,3,4,5,6};
        int n = arr.length;
        rearrange(arr,n);
        for(int i: arr) {
            System.out.print(i+" ");
        }
    }

    /**
     *
     Given a sorted array of positive integers.
     Your task is to rearrange  the array elements alternatively i.e first element should be max value,
     second should be min value, third should be second max, fourth should be second min and so on.
     */
    public static void rearrange(int [] arr, int n) {
        int i=0;
        int j= n-1;
        int maxElement = arr[n-1]+1;
        for(int k=0;k<n;k++) {
            if(k%2==0) {
                arr[k]= arr[k]+(arr[j]%maxElement)*maxElement;
                j--;
            } else {
                arr[k]= arr[k]+(arr[i]%maxElement)*maxElement;
                i++;
            }
        }
        for(int k=0;k<n;k++) {
            arr[k]=arr[k]/maxElement;
        }

    }
}
