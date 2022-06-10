package datastructure.string;

public class ImplementAtoi {
    public static void main(String[] args) {
        String str = "123";
        String[] strArr = new String[]{"123","-10","0","000","1010","010","+1287", "ABC", "12B","12C1"};
        //String str = "-12";
        // String str = "12a";
        for(String s: strArr) {
            System.out.print(atoi(s)+" ");
            System.out.print(atoi1(s)+" ");
            System.out.println();
        }
    }

    static int atoi(String str) {
        int result = 0;
        int powIndex = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char x = str.charAt(i);
            if (i == 0 && x == '-') {
                result = result * -1;
                break;
            }
            int v = x - '0';
            if (v < 0 || v > 9) {
                result = -1;
                break;
            } else {
                result = result + (v * (int) Math.pow(10, powIndex));
                powIndex++;
            }
        }
        return result;

    }

    static int atoi1(String str) {
        int result = 0;
        int flag = 1;
        int i=0;
        if (str.charAt(0)=='-') {
            flag = -1;
            i = 1;
        }
        for (;i < str.length(); i++) {
            char x = str.charAt(i);
            int v = x - '0';
            if (v < 0 || v > 9) {
                result = -1;
                break;
            } else {
                result = (10*result) + v;
            }
        }

        long l=0L;

        return result*flag;

    }
}
