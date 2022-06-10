package collections;

import java.util.HashMap;
import java.util.Map;

public class LRU2 {

    private final int capacity;
    private Node head;
    private Node tail;
    private final Map<Integer,Node> cache;

    public LRU2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        else {
            Node existingNode = cache.get(key);
            remove(existingNode);
            addFirst(existingNode);
            return existingNode.value;
        }
    }

    public void set(int key, int value) {
        if(cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            existingNode.value=value;
            remove(existingNode);
            addFirst(existingNode);
        } else {
            Node newNode = new Node(key,value);
            if(cache.size()==capacity) {
                cache.remove(tail.key);
                remove(tail);
            }
            addFirst(newNode);
            cache.put(key,newNode);
        }
    }

    private void addFirst(Node node) {
        if(head==null) {
            head=node;
            tail=node;
        } else {
            head.prev = node;
            node.next=head;
            node.prev = null;
            head= node;
        }
    }

    private void remove(Node existingNode) {
        if(existingNode==tail) {
            removeLast();
        } else if(existingNode!=head) {
            existingNode.prev.next = existingNode.next;
            existingNode.next.prev = existingNode.prev;
        }
    }

    private void removeLast() {
        Node prev = tail.prev;
        prev.next =null;
        tail=prev;
    }

    public void clear() {
        cache.clear();
        head=null;
        tail=null;
    }

    public void print() {
        System.out.print("cache::::   ");
        Node curr = head;
        while(curr!=null) {
            System.out.print(curr.key+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public void print1() {
        System.out.print("cache::::   ");
        for(int key: cache.keySet()) {
            System.out.print(key+ " ");
        }
        System.out.println();
    }

    public static void main(String [] args) {
        LRU2 cache = new LRU2(4);
        cache.set(1,100);
        cache.set(2,200);
        cache.set(3,300);
        cache.set(4,400);
        cache.print();
        cache.set(1,101);
        cache.print();
        cache.set(2,202);
        cache.print();
        cache.set(5,500);
        cache.print();
        cache.set(6,600);
        cache.print();
        System.out.println("value fetched is:: "+cache.get(3));
        cache.print();
        System.out.println("value fetched is:: "+cache.get(4));
        cache.print();
        cache.set(7,700);
        cache.print();
        System.out.println("value fetched is:: "+cache.get(1));
        cache.print();
        System.out.println("value fetched is:: "+cache.get(8));
        cache.print();
        cache.set(8,800);
        cache.print();
        System.out.println("value fetched is:: "+cache.get(7));
        cache.print();
        cache.clear();
        cache.print();
        cache.print1();
    }

}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value=value;
    }
}
