package datastructure.linkedlist;

public class ReverseLinkedList {
    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(3);
        list1.addNodeAtEnd(4);
        list1.addNodeAtEnd(5);
        list1.addNodeAtEnd(6);
        list1.addNodeAtEnd(7);
        Linkedlist.print(reverse(list1.head));
    }

    static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev= null;
        LinkedListNode current =head;
        LinkedListNode next = head;
        while(current !=null) {
            next = current.next;
            current.next= prev;
            prev= current;
            current = next;
        }
        head= prev;
        return head;
    }
}
