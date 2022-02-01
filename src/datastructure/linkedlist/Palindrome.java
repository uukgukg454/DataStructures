package datastructure.linkedlist;

public class Palindrome {

    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(1);
        System.out.println("Non Recursive approach: "+ isPalindromeNonRecursive(list1.head));
        Linkedlist.print(list1.head);
        System.out.println("\n");
        System.out.println("Recursive approach: "+ isPalindromeRecursive(list1.head));
        Linkedlist.print(list1.head);

    }

    static boolean isPalindromeNonRecursive(LinkedListNode head)
    {
        boolean result= true;
        LinkedListNode slow =head;
        LinkedListNode fast = head;
        LinkedListNode prev= head;
        LinkedListNode secondHalfStart;
        LinkedListNode midNode =null;
        while(fast!=null && fast.next!=null )
        {
            prev= slow;
            slow= slow.next;
            fast=fast.next.next;
        }
        if(fast !=null) {
            midNode=slow;
            slow=slow.next;
        }
        secondHalfStart = slow;
        prev.next= null;
        if(midNode !=null) {
            midNode.next = null;
        }

        secondHalfStart = reverse(secondHalfStart);

        LinkedListNode firstHalfCurrent = head;
        LinkedListNode secondHalfCurrent = secondHalfStart;

        while(firstHalfCurrent !=null && secondHalfCurrent !=null) {
            if(firstHalfCurrent.data != secondHalfCurrent.data) {
                result= false;
                break;
            }
            firstHalfCurrent = firstHalfCurrent.next;
            secondHalfCurrent= secondHalfCurrent.next;
        }

        secondHalfStart = reverse(secondHalfStart);

        if(midNode !=null) {
            midNode.next = secondHalfStart;
            prev.next= midNode;
        } else {
            prev.next = secondHalfStart;
        }
        return result;
    }

    static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev= null;
        LinkedListNode current =head;
        LinkedListNode next;
        while(current !=null) {
            next = current.next;
            current.next= prev;
            prev= current;
            current = next;
        }
        head= prev;
        return head;
    }

    static boolean isPalindromeRecursive(LinkedListNode head) {
        NodeWrapper left = new NodeWrapper(head);
        return isPalindromeRecursiveUtil(left, head);

    }

    static boolean isPalindromeRecursiveUtil(NodeWrapper left, LinkedListNode right) {

        if(right==null) {
            return true;
        }
        boolean result = isPalindromeRecursiveUtil(left, right.next) && (left.node.getData()== right.data);

        left.node= left.node.next;

        return result;
    }
}
class NodeWrapper {
    public  LinkedListNode node;

    public NodeWrapper(LinkedListNode node) {
        this.node = node;
    }
}
