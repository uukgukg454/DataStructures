package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU1 {
    private final int capacity;
    private final Map<Integer,String> map;

    public LRU1(int capacity) {
       this.capacity=capacity;
       this.map =  new LinkedHashMap<>(capacity);
    }
    public String get(int key) {
        if(!map.containsKey(key)) {
            return null;
        } else {
            String value=  map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
    }

    public void put(int key, String value) {
        if(map.containsKey(key)) {
            map.remove(key);
        } else {
            if(map.size()==capacity) {
                map.remove(map.keySet().iterator().next());
            }
        }
        map.put(key,value);
    }

    public void print() {
        System.out.print("cache::::   ");
        for(int key: map.keySet()) {
            System.out.print(key+ " ");
        }
        System.out.println();
    }

    public static void main(String [] args) {
        LRU1 cache = new LRU1(4);
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
