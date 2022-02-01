package datastructure.linkedlist;

public class DetectLoop {
    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(3);
        list1.addNodeAtEnd(4);
        list1.addNodeAtEnd(5);
        LinkedListNode current= list1.head;
        while(current.next !=null) {
            current = current.next;
        }
        current.next=list1.head.next;

        System.out.println(detect(list1.head));
    }

    static boolean detect(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        boolean loopFound = false;
        while(fast !=null && fast.next!=null) {
            slow= slow.next;
            fast= fast.next.next;
            if(slow==fast) {
                loopFound = true;
                break;
            }
        }
        return loopFound;
    }
}
