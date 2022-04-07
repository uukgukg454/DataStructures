package datastructure.linkedlist;

public class RandomPointerLinklistClone {

    public LinkedListNode copyRandomList(LinkedListNode head) {
        if(head==null)
            return null;

        LinkedListNode temp = head;

        while(temp !=null) {
            LinkedListNode node = new LinkedListNode(temp.data);
            node.next= temp.next;
            temp.next = node;
            temp = node.next;
        }

        temp = head;
        while(temp !=null && temp.next !=null) {
            if(temp.random==null)
                temp.next.random=null;
            else
                temp.next.random = temp.random.next;
            temp=temp.next.next;
        }
        LinkedListNode head1 = head.next;
        temp = head;

        while(temp!=null && temp.next!=null) {
            LinkedListNode temp1 = temp.next;
            temp.next = temp1.next;
            temp=temp1;
        }
        return head1;
    }

    static class LinkedListNode {
        int data;
        LinkedListNode next;
        LinkedListNode random;

        LinkedListNode(int data) {
            this.data= data;
        }
    }
}
