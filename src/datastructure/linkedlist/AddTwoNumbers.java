package datastructure.linkedlist;

import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(4);
        list1.addNodeAtEnd(5);

        Linkedlist list2 = new Linkedlist();
        list2.addNodeAtEnd(3);
        list2.addNodeAtEnd(4);
        list2.addNodeAtEnd(5);
        LinkedListNode  result= addUsingStack(list1.head, list2.head);
        Linkedlist.print(result);
    }

    static LinkedListNode  addUsingStack(LinkedListNode  first, LinkedListNode  second){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int carry= 0;
        LinkedListNode  resultHead = null;
        while(first!=null) {
            s1.push(first.data);
            first= first.next;
        }
        while(second!=null) {
            s2.push(second.data);
            second= second.next;
        }

        while(!s1.isEmpty() && !s2.isEmpty()) {
            int ele1 = s1.pop();
            int ele2 = s2.pop();
            LinkedListNode  newNode = new LinkedListNode ((ele1+ele2+carry)%10);
            carry = (ele1+ele2+carry)/10;
            if(resultHead ==null) {
                resultHead= newNode;
            } else {
                newNode.next= resultHead;
                resultHead= newNode;
            }
        }
        while(!s1.isEmpty()) {
            int ele = s1.pop();
            LinkedListNode  newNode = new LinkedListNode((ele+carry)%10);
            carry= (ele+carry)/10;
            newNode.next= resultHead;
            resultHead= newNode;
        }
        while(!s2.isEmpty()) {
            int ele = s2.pop();
            LinkedListNode  newNode = new LinkedListNode((ele+carry)%10);
            carry= (ele+carry)/10;
            newNode.next= resultHead;
            resultHead= newNode;
        }
        if(carry!=0) {
            LinkedListNode  newNode  = new LinkedListNode(carry);
            newNode.next= resultHead;
            resultHead= newNode;
        }
        return resultHead;
    }
}
