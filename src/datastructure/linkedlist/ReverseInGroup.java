package datastructure.linkedlist;

public class ReverseInGroup {
    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(3);
        list1.addNodeAtEnd(4);
        list1.addNodeAtEnd(5);
        list1.addNodeAtEnd(6);
        list1.addNodeAtEnd(7);

        int k =3;
        Linkedlist.print(reverse(list1.head,k));
    }

    private static LinkedListNode reverse(LinkedListNode head, int k) {
        LinkedListNode current = head;
        LinkedListNode prev= null;
        LinkedListNode next=null;
        int count =0;

        while(current!=null && count<k) {
            next= current.next;
            current.next = prev;
            prev= current;
            current = next;
            count++;
        }
        if(next !=null) {
            head.next = reverse(next,k);
        }
        head =prev;
        return head;

    }
}
