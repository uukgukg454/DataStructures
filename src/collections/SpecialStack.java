package collections;

import java.util.Stack;

public class SpecialStack {

    public static void main(String [] args) {
        MyStack stack = new MyStack();
        stack.push(8);
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(0);
        stack.push(18);
        System.out.println("poppedElement:"+ stack.pop());
        System.out.println("minElement:"+ stack.getMin());
        System.out.println("poppedElement:"+ stack.pop());
        System.out.println("minElement:"+ stack.getMin());
        System.out.println("poppedElement:"+ stack.pop());
        System.out.println("poppedElement:"+ stack.pop());
        System.out.println("poppedElement:"+ stack.pop());
        System.out.println("minElement:"+ stack.getMin());

    }
}

/**
 * support getMin in o(1)
 */
class MyStack
{
    int minEle;
    Stack<Integer> s;
    int getMin() {
        if(s==null || s.isEmpty())
            return -1;
        return minEle;
    }

    int pop() {
        if(s==null || s.isEmpty())
            return -1;
        int poppedEle = s.pop();
        if(poppedEle>=minEle)
            return poppedEle;
        else {
            int temp = minEle;
            minEle = 2*minEle-poppedEle;
            return temp;
        }
    }

    void push(int x) {
        if(s==null)
            s= new Stack<>();
        if(s.isEmpty()) {
            s.push(x);
            minEle = x;
        } else {
            if(x>=minEle)
                s.push(x);
            else {
                s.push(2 * x - minEle);
                minEle = x;
            }
        }
    }
}
