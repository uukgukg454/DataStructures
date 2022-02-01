package datastructure.string;

public class ImplementStrStr {
    public static void main(String[] args) {
        String str1 = "ujtjwal";
        String str2 = "jwa";
        System.out.println(strstr(str1,str2));
    }

    static int strstr(String s, String x) {
        int index =-1;
        int j =0;
        for(int i=0;i<s.length();i++) {
            index =i;
            while(j<x.length() && i<s.length() && s.charAt(i)==x.charAt(j)) {
                j++;
                i++;
            }
            if(j==x.length())
                return index;
            else {
                i= index;
                j=0;
            }
        }
        return -1;
    }
}
