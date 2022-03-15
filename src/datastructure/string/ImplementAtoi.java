package datastructure.string;

public class ImplementAtoi {
    public static void main(String[] args) {
        String str = "123";
        //String str = "-12";
        // String str = "12a";
        System.out.println(atoi(str));
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
}
