package datastructure.array;

public class NextGreaterNumberUsingSameDigit {

    public static void main(String[] args) {
        int n = 457894;
        System.out.println("next greater number using same digits is:"+findNextGreaterElement(n));
    }
    private static int findNextGreaterElement(int n) {
        char[] arr = ("" + n).toCharArray();
        int i;
        for(i=arr.length-1;i>0;i--) {
            if(arr[i-1]<arr[i]) {
                break;
            }
        }
        if(i==0)
            return -1;
        else {
            for (int j = arr.length- 1; j >= i; j--) {
                if (arr[i - 1] < arr[j]) {
                    swap(arr,i - 1, j);
                    break;
                }
            }
            reverse(arr, i);
        }
        try {
            return Integer.parseInt(new String(arr));
        } catch (Exception e) {
            return -1;
        }

    }

    private static void reverse(char[] arr, int start) {
        int l = start, r = arr.length - 1;
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
