package datastructure.stackqueue;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = ")()())(())";
        System.out.println("Longest Valid Parentheses is: "+ longestValidParentheses(s));
    }

    private static int longestValidParentheses(String s) {
        if(s.isEmpty())
            return 0;
        int maxCount=0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            if(c=='(' )
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
                if(! stack.isEmpty())
                {

                    maxCount= Math.max(maxCount, (i-stack.peek()));

                }
                else
                {
                    stack.push(i);
                }
            }
        }
        return maxCount;
    }
}
