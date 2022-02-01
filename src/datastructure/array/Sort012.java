package datastructure.array;

public class Sort012 {

    public static void main(String [] args) {
        int [] arr= {0,1,0,0,1,1,2,2,0,2,1,0,1};
        int n = arr.length;
        sort012(arr,n);
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println("\n");
        sort021(arr,n);
        for(int i: arr) {
            System.out.print(i+" ");
        }
    }

    public static void sort012(int a[], int n)
    {
        int low =0;
        int mid =0;
        int high = n-1;
        int temp;
        while(mid<=high) {
            switch(a[mid]) {
                case 0:
                    temp = a[low];
                    a[low]= a[mid];
                    a[mid]= temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[high];
                    a[high]= a[mid];
                    a[mid]= temp;
                    high--;
                    break;
            }
        }
    }

    public static void sort021(int a[], int n)
    {
        int low =0;
        int mid =0;
        int high = n-1;
        int temp;
        while(mid<=high) {
            switch(a[mid]) {
                case 0:
                    temp = a[low];
                    a[low]= a[mid];
                    a[mid]= temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    temp = a[high];
                    a[high]= a[mid];
                    a[mid]= temp;
                    high--;
                    break;
                case 2:
                    mid++;
                    break;
            }
        }
    }
}
