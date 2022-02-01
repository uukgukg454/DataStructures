package datastructure.linkedlist;

public class NthElementFromLast {
    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(3);
        list1.addNodeAtEnd(4);
        list1.addNodeAtEnd(5);
        int n =2;
        System.out.println(findElementFromStart(list1.head, n));
    }

    static int findElementFromStart(LinkedListNode head, int n){
        LinkedListNode current = head;
        int count = 0;
        while(current !=null) {
            count++;
            current= current.next;
        }
        if(count<n) {
            return -1;
        }
        int diff = count-n;
        current =head;
        while(diff !=0) {
            current= current.next;
            diff--;
        }
        return current.data;
    }
}
