package datastructure.dp;

import java.util.Arrays;

public class LongestPalindromicSequence {

    public static void main(String[] args) {
        String str = "adbbca";
        System.out.println("length of LPS is: " + count(str));
        System.out.println("length of LPS is: " + countNewApproach(str));
    }

    public static int count(String str) {
        int n = str.length();
        int[][] arr = new int[n][n];
        int i;
        int j;
        for (i = 0; i < str.length(); i++) {
            arr[i][i] = 1;
        }
        int k = 2;
        while (k <= n) {
            i = 0;
            while (i + k <= n) {
                j = i + k - 1;
                if (str.charAt(i) == str.charAt(j))
                    arr[i][j] = 2 + arr[i + 1][j - 1];
                else
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i + 1][j]);
                i++;
            }
            k++;
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
        int n = arr[0].length - 1;
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

    static int countNewApproach(String s) {
        int n = s.length();
        int [][] dpArr= new int[n][n];
        for(int i=0;i<n;i++) {
            dpArr[i][i]= 1;
        }
        for(int k=0;k<=n-2;k++) {
            for(int i=0,j=i+k+1;j<n;j++,i++)
            {
                if(s.charAt(i)==s.charAt(j)) {
                    dpArr[i][j]= 2+dpArr[i+1][j-1];
                }
                else {
                    dpArr[i][j]= Math.max(dpArr[i][j-1],dpArr[i+1][j]);
                }
            }
        }
        return dpArr[0][n-1];
    }
}
