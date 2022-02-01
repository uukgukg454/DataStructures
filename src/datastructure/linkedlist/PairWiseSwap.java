package datastructure.linkedlist;

public class PairWiseSwap {
    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(3);
        list1.addNodeAtEnd(4);
        list1.addNodeAtEnd(5);
        list1.addNodeAtEnd(6);
        list1.addNodeAtEnd(7);
        //Linkedlist.print(swapByData(list1.head));
        Linkedlist.print(swapByLinks(list1.head,2));
    }

    private static LinkedListNode swapByData(LinkedListNode head) {
        LinkedListNode current = head;
        int temp;
        while(current !=null && current.next !=null) {
            temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current= current.next.next;
        }
        return head;
    }

    private static LinkedListNode swapByLinks(LinkedListNode head, int k) {
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
            head.next = swapByLinks(next,k);
        }
        head =prev;
        return head;

    }
}
