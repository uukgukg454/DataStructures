package datastructure.dp;

public class LongestCommonSequence {
    public static void main(String[] args) {
        String str1 = "bqdrcvefgh";
        String str2 = "abcvdefgh";
        System.out.println(LCS(str1,str2));
    }

    private static int LCS(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int [][] arr= new int[n1+1][n2+1];

        /*for(int i=0;i<=n1;i++)
            arr[i][0]=0;
        for(int i=0;i<=n2;i++)
            arr[0][i]=0;*/
        for(int i=0;i<=n1;i++) {
            for(int j=0;j<=n2;j++) {
                if(i==0 || j==0)
                    arr[i][j]=0;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                   arr[i][j] = arr[i-1][j-1]+1;
                else
                    arr[i][j]= Math.max(arr[i-1][j],arr[i][j-1]);
            }
        }
        System.out.println("DP Matrix is:");
        for(int i=0;i<=n1;i++) {
            for (int j = 0; j <= n2; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("LCS is:"+printCommonSubSequence(arr, str1,str2));
        return arr[n1][n2];
    }

    private static String printCommonSubSequence(int[][] arr, String str1, String str2) {
        String result ="";
        int n1 = str1.length();
        int n2 = str2.length();
        int i= n1;
        int j= n2;
        while(i>0 && j>0) {
            if(str1.charAt(i-1)==str2.charAt(j-1)) {
                result = str1.charAt(i-1)+result;
                i--;
                j--;
            } else {
                if(arr[i-1][j]>arr[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        return result;
    }
}
