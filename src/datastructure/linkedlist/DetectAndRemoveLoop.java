package datastructure.linkedlist;

public class DetectAndRemoveLoop {

    public static void main(String[] args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(3);
        list1.addNodeAtEnd(4);
        list1.addNodeAtEnd(5);
        LinkedListNode current = list1.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list1.head;

       detectAndRemove(list1.head);
       Linkedlist.print(list1.head);
    }

    static void detectAndRemove(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            } else { // when start of loop is head. in other words when slow and fast meets at head(start of linked list))
                while (fast.next != slow) {
                    fast = fast.next;
                }
            }
            fast.next = null;
        }
    }
}
