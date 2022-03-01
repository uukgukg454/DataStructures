package datastructure.dp;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "aaaabbaa";
        System.out.println(LPS(str));
        System.out.println(LPSEfficient(str));
        System.out.println(LPSNewApproach(str));
    }

    //Time complexity: o(n^2) and space complexity: o(n^2)
    static String LPS(String str) {
        int n = str.length();
        int j;
        int start =-1;
        int maxLength =1;
        boolean [][] arr = new boolean[n][n];

        for(int i=0;i<n-1;i++)
            arr[i][i]=true;

        for(int i=0;i<n-1;i++) {
            j= i+1;
            if(str.charAt(i)==str.charAt(j)) {
                arr[i][j]=true;
                maxLength=2;
                start=i;
            }
        }

        for(int k=3;k<=n;k++) {
            for (int i = 0; i + k <= n; i++) {
                j = i + k - 1;
                if (str.charAt(i) == str.charAt(j) && arr[i + 1][j - 1]) {
                    arr[i][j] = true;
                    if (k > maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }

        return str.substring(start,start+maxLength);
    }

    //Time complexity: o(n^2) and space complexity: o(1)
    static String LPSEfficient(String str) {
        int n = str.length();
        int low;
        int high;
        int start=0;
        int maxLength = 1;
        for(int i=1;i<n;i++) {
            //even length palindrome around i;
            low = i-1;
            high =i;
            while(low>=0 && high<n && str.charAt(low)==str.charAt(high)) {
                low--;
                high++;
            }
            ++low;
            high--;
            if(str.charAt(low)==str.charAt(high) && (high-low+1)>maxLength) {
                start =low;
                maxLength= high-low+1;
            }

            //odd length palindrome around i;
            low = i-1;
            high =i+1;
            while(low>=0 && high<n && str.charAt(low)==str.charAt(high)) {
                low--;
                high++;
            }
            ++low;
            high--;
            if(str.charAt(low)==str.charAt(high) && (high-low+1)>maxLength) {
                start =low;
                maxLength= high-low+1;
            }
        }
        return str.substring(start,start+maxLength);
    }

    static String LPSNewApproach(String s) {
        int n = s.length();
        boolean [][] dpArr= new boolean[n][n];
        int start = -1;
        int maxLength = 1;
        for(int i=0;i<n;i++) {
            dpArr[i][i]= true;
            start =i;
        }


        for(int k=0;k<=n-2;k++) {
            for(int i=0,j=i+k+1;j<n;j++,i++)
            {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i==1) {
                        dpArr[i][j]=true;
                        maxLength =2;
                        start =i;
                    } else if (dpArr[i+1][j-1]) {
                        dpArr[i][j]=true;
                        if(j-i+1>maxLength) {
                            maxLength = j-i+1;
                            start =i;
                        }
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
}
