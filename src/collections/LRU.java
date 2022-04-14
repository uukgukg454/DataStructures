package collections;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU<K,V> {

    private final Map<K,V> map;
    private final Deque<K> list ;
    private final int capacity;

    public LRU(int capacity) {
        this.list = new LinkedList<>();
        this.capacity = capacity;
        this.map =  new HashMap<>();
    }

    public V get(K key) {
        if(!map.containsKey(key)) {
            return null;
        } else {
            list.remove(key);
            list.addFirst(key);
            return map.get(key);
        }
    }

    public void put(K key, V value) {
        if(map.containsKey(key)) {
            list.remove(key);
        } else {
            if(list.size()>=capacity) {
               K evictedKey =  list.removeLast();
                map.remove(evictedKey);
            }
        }
        map.put(key,value);
        list.addFirst(key);
    }

    public void print() {
        System.out.print("cache::::   ");
        for(K key: list) {
            System.out.print(key+ " ");
        }
        System.out.println();
    }

    public static void main(String [] args) {
        LRU<Integer,String> cache = new LRU<>(4);
        cache.put(1,"A");
        cache.put(2,"B");
        cache.put(3,"C");
        cache.put(4,"D");
        cache.print();
        cache.put(5,"E");
        cache.print();
        cache.put(6,"F");
        cache.print();
        System.out.println("value fetched is:: "+cache.get(3));
        cache.print();
        System.out.println("value fetched is:: "+cache.get(4));
        cache.print();
        System.out.println("value fetched is:: "+cache.get(1));
        cache.print();
        System.out.println("value fetched is:: "+cache.get(8));
        cache.print();
        cache.put(7,"G");
        cache.print();
        System.out.println("value fetched is:: "+cache.get(7));
        cache.print();
    }
}
