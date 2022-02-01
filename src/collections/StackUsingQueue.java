package collections;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String [] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class CustomStack<E> {
    Queue<E> q1;
    Queue<E> q2;

    public CustomStack() {
        q1= new LinkedList<>();
        q2 = new LinkedList<>();
    }
    void push(E a) {
        if(q1.isEmpty()) {
            q1.add(a);
            while(!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }
        else {
            q2.add(a);
            while(!q1.isEmpty()) {
                q2.add(q1.remove());
            }
        }

    }

    E pop() {
        if(q1.isEmpty() && q2.isEmpty())
            return null;
        else if(q1.isEmpty())
            return q2.remove();
        else
            return q1.remove();
    }

    void push1(E a) {
        while(!q1.isEmpty())
        {
            q2.add(q1.remove());
        }
        q1.add(a);
        while(!q2.isEmpty())
        {
            q1.add(q2.remove());
        }
    }

    E pop1() {
        if(q1.isEmpty())
            return null;
        return q1.remove();
    }

    void push11(E e) {
        q2.add(e);
        while(!q1.isEmpty())
        {
            q2.add(q1.remove());
        }
        Queue<E> q3= q1;
        q1=q2;
        q2=q3;
    }


}
