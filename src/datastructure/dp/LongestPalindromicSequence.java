package datastructure.dp;

import java.util.Arrays;

public class LongestPalindromicSequence {

    public static void main(String[] args) {
        String str = "adbbca";
        System.out.println("length of LPS is: " + count(str));
    }

    public static int count(String str) {
        int n = str.length();
        int[][] arr = new int[n][n];
        int i;
        int j;
        for (i = 0; i < str.length(); i++) {
            arr[i][i] = 1;
        }
        int l = 2;
        while (l <= n) {
            i = 0;
            while (i + l <= n) {
                j = l + i - 1;
                if (str.charAt(i) == str.charAt(j))
                    arr[i][j] = 2 + arr[i + 1][j - 1];
                else
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i + 1][j]);
                i++;
            }
            l++;
        }
        System.out.println("DP Matrix is:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println("LPS is: " + LPS(arr, str));
        return arr[0][n - 1];
    }

    public static String LPS(int[][] arr, String str) {
        int n = arr.length - 1;
        char[] result = new char[arr[0][n]];
        int i = 0;
        int j = n;
        int result_start = 0;
        int result_end = result.length - 1;
        while (result_end - result_start > 0) {
            if (str.charAt(i) == str.charAt(j)) {
                result[result_start] = str.charAt(i);
                result[result_end] = str.charAt(i);
                result_start++;
                result_end--;
                i++;
                j--;
            } else {
                if (arr[i][j - 1] > arr[i + 1][j])
                    j--;
                else
                    i++;
            }
        }
        if (result_end == result_start)
            result[result_end] = str.charAt(i);
        return Arrays.toString(result);
    }
}
