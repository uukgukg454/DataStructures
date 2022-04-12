package datastructure.string;

public class LongestCommonPrefix {

    public static void main(String [] args) {
        String [] arr= {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(longestCommonPrefix(arr,arr.length));
    }

    static String longestCommonPrefix(String[] arr, int n){
        String prefix = arr[0];
        for(int i=1;i<n;i++) {
            prefix = CommonPrefixUtil(prefix,arr[i]);
        }
        return prefix.equals("")?"-1":prefix;
    }

    static String CommonPrefixUtil(String str1, String str2) {
        String result="";
        int n1= str1.length();
        int n2 = str2.length();
        for(int i=0,j=0;i<n1 && j<n2;i++,j++) {
            if(str1.charAt(i)!=str2.charAt(j)) {
                break;
            }
            result =result+str1.charAt(i);
        }
        return result;
    }
}
