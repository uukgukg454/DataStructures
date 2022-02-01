package datastructure.linkedlist;

public class MiddleElement {

    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(3);
        list1.addNodeAtEnd(4);
        list1.addNodeAtEnd(5);
        System.out.println(find(list1.head));
    }

    static int find(LinkedListNode head) {
        LinkedListNode slow= head;
        LinkedListNode fast = head;
        while(fast!=null && fast.getNext() !=null) {
            slow = slow.getNext();
            fast= fast.getNext().getNext();
        }
        return slow.getData();
    }

}

