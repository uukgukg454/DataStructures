package datastructure.linkedlist;

public class Sort012 {
    public static void main(String []args) {
        Linkedlist list1 = new Linkedlist();
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(0);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(1);
        list1.addNodeAtEnd(0);
        list1.addNodeAtEnd(0);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(2);
        list1.addNodeAtEnd(1);
        Linkedlist.print(sortByChangingLinks(list1.head));
        System.out.println("\n");
        //sortByChangingByData(Linkedlist.head);
        //Linkedlist.print(Linkedlist.head);
    }

    static LinkedListNode sortByChangingLinks(LinkedListNode head)
    {

        LinkedListNode Start0 = new LinkedListNode(0);
        LinkedListNode Start1= new LinkedListNode(0);
        LinkedListNode Start2 = new LinkedListNode(0);

        LinkedListNode head0 = Start0;
        LinkedListNode head1 = Start1;
        LinkedListNode head2 = Start2;

        LinkedListNode current = head;
        while(current !=null) {
            int data = current.data;
            if(data==0) {
                head0.next= current;
                head0=head0.next;
            } else if(data==1) {
                head1.next= current;
                head1=head1.next;
            }else {
                head2.next= current;
                head2=head2.next;
            }
            current = current.next;
        }
        head0.next=(Start1.next !=null)?Start1.next:Start2.next;
        head1.next= Start2.next;
        head2.next = null;
        return Start0.next;
    }

    static void sortByChangingByData(LinkedListNode head) {
        int [] count = {0,0,0};
        LinkedListNode current = head;
        while(current !=null) {
            count[current.data]++;
            current = current.next;
        }
        current = head;
        int i= 0;
        while(current !=null) {
          if(count[i]==0) {
              i++;
          } else {
              current.data =i;
              count[i]--;
              current=current.next;
          }
        }
    }
}
