package datastructure.stackqueue;

import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in the array.
 * Elements for which no greater element exist, consider the next greater element as -1.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        //int[] arr = { 11, 13, 21, 3 };
        int [] arr= {4, 5, 2, 25, 10};
        int n = arr.length;
        int [] result = findNextGreater(arr);
        for(int i: result) {
            System.out.print(i+" ");
        }
    }

    private static int[] findNextGreater(int [] arr) {
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (!s.empty())
            {
                while (!s.empty() && s.peek() <= arr[i]) {
                    s.pop();
                }
            }
            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        return nge;
    }
}
