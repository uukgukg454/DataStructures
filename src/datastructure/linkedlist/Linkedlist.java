package datastructure.linkedlist;

public class Linkedlist {

    public LinkedListNode head;

    public void addNodeAtEnd(int element) {
        LinkedListNode newNode= new LinkedListNode(element);
        if(head==null) {
            head=newNode;
        } else {
            LinkedListNode current = head;
            while(current.getNext() !=null) {
                current=current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public static void print(LinkedListNode head) {
        LinkedListNode current = head;
        while(current !=null) {
            System.out.print(current.data+" ");
            current =current.next;
        }
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;


    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}



