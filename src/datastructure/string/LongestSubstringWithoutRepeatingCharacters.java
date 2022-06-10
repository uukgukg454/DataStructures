package datastructure.string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String [] args) {
        String str = "abcabbc";
        System.out.println("max length::"+lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty())
            return 0;
        int n = s.length();
        int start = 0;
        int maxLength = 0;
        int i=0;
        int st =0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(;i<n;i++) {
            char c= s.charAt(i);
            if(hm.containsKey(c)) {
                start = Math.max(start,hm.get(c)+1);
            }
            hm.put(c,i);
            if(i-start+1>maxLength) {
                maxLength= i-start+1;
                st =start;
            }
        }
        System.out.println("substring with no duplicate characters:"+(s.substring(st,st+maxLength)));
        return maxLength;
    }
}
