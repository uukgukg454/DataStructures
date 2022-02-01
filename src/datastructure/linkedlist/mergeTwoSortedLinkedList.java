package datastructure.linkedlist;

public class mergeTwoSortedLinkedList {
    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(5);
        list1.addNodeAtEnd(10);
        list1.addNodeAtEnd(15);
        list1.addNodeAtEnd(40);

        Linkedlist list2 = new Linkedlist();
        list2.addNodeAtEnd(2);
        list2.addNodeAtEnd(3);
        list2.addNodeAtEnd(20);
        Linkedlist.print(sortedMerge(list1.head,list2.head));
    }

    static LinkedListNode  sortedMerge(LinkedListNode  head1, LinkedListNode  head2) {
        LinkedListNode  dummyNode = new LinkedListNode(0);
        LinkedListNode  tail= dummyNode;
        while(true) {
            if(head1==null) {
                tail.next = head2;
                break;
            }
            if(head2==null) {
                tail.next = head1;
                break;
            }
            if(head1.data>head2.data) {
                tail.next= head2;
                head2= head2.next;
            } else {
                tail.next= head1;
                head1= head1.next;
            }
            tail =tail.next;
        }
        return dummyNode.next;
    }
}
