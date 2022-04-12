package datastructure.search;

public class BinarySearch {
    public static void main(String [] args) {
        int [] arr = {1,2,3,4,5};
        int [] targetArr = {1,2,3,4,5,6,0};
        for(int target: targetArr) {
            System.out.println("target found at index:"+search(0, arr.length-1,arr,target));
        }
}

static int search(int l, int r, int [] arr, int target) {
    if (l > r)
        return -1;
    int mid = l + (r - l) / 2;
    if (arr[mid] == target)
        return mid;
    if (arr[mid] > target)
        return search(l, mid - 1, arr, target);
    return search(mid + 1, r, arr, target);
}
}
