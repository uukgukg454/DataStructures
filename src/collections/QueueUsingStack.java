package collections;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String [] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();
        System.out.println(queue.pop());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

class CustomQueue<E> {
    Stack<E> s1;
    Stack<E> s2;

    public CustomQueue() {
        s1= new Stack<>();
        s2 = new Stack<>();
    }

    void push(E x) {
        s1.push(x);
    }

    E pop() {
        E poppedElement;
        if(!s2.isEmpty())
            poppedElement = s2.pop();
        else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            poppedElement = s2.isEmpty()? null :s2.pop();
        }
        return poppedElement;
    }
}
