package datastructure.string;

import java.util.HashMap;

public class RomanToNumber {
    public static void main(String [] args) {
        String str= "MCD";
        //String str = "IXI";
       // String str = "IXI";
        System.out.println(romanToDecimal(str));
    }

    static int romanToDecimal(String str) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int result =0;
        Character prev =null;

        for(int i=0;i<str.length();i++) {
            char x = str.charAt(i);
            int v = hm.get(x);
            result = result+v;
            if(prev!=null && prev!=x && hm.get(prev)<v) {
                result = result-2*hm.get(prev);
            }
            prev =x;
        }
        return result;
    }
}
