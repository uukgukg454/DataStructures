package datastructure.stackqueue;

import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String [] args) {
        String x = "{}[](())[{()}]";
        System.out.println(isBalanced(x));
    }

    static boolean isBalanced(String x)
    {
        boolean result = true;
        Stack<Character> s = new Stack<>();
        for(int i=0;i<x.length();i++) {
            char c = x.charAt(i);
            if(c=='{' || c== '[' || c=='(')
                s.push(c);
            else if(s.isEmpty()) {
                result= false;
                break;
            }
            else {
                char top = s.pop();
                if((c=='}' && top != '{')
                        ||  (c==']' && top != '[')
                        ||  (c==')' && top != '(')) {
                    result = false;
                    break;
                }
            }
        }
        if(!s.isEmpty()) {
            result= false;
        }
        return result;
    }
}
