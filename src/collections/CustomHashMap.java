package collections;

public class CustomHashMap<K,V> {

    public static final int DEFAULT_CAPACITY = 16;

    private final int capacity;

    private final Entry<K,V>[] arr;

    public CustomHashMap() {
       this(DEFAULT_CAPACITY);
    }

    public CustomHashMap(int capacity) {
        this.capacity= capacity;
        this.arr = new Entry[capacity];
    }

    static class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> nextEntry) {
            this.key=key;
            this.value=value;
            this.next = nextEntry;
        }
    }

    public void put(K key, V value) {
        Entry<K,V> entry = new Entry<>(key, value,null);
        int index = hash(key);
        if(arr[index]==null) {
            arr[index]=entry;
        } else {
            Entry<K,V> previousEntry = null;
            Entry<K,V> currentEntry = arr[index];
            while(currentEntry !=null) {
                if(currentEntry.key==null) {
                    currentEntry.value=value;
                    break;
                }
                if(currentEntry.key.equals(entry.key)) {
                   currentEntry.value= value;
                   break;
                } else {
                    previousEntry = currentEntry;
                    currentEntry = currentEntry.next;
                }
            }
            if(previousEntry!=null)
                previousEntry.next= entry;
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = arr[index];
        while (entry != null) {
            if(entry.key==null) {
                return entry.value;
            }
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private int hash(K key) {
        if(key==null){
            return 0;
        }
        int keyHashCode = Math.abs(key.hashCode());
        return keyHashCode%capacity;
    }

    public static void main(String [] args) {
        CustomHashMap<String,String> map = new CustomHashMap<>();
        map.put("Ujjwal","1");
        map.put(null,"2");
        map.put(null,"4");
        map.put("Monika","3");
        map.put("Ujjwal","0");
        System.out.println("value for key:Ujjwal is: "+map.get("Ujjwal"));
        System.out.println("value for key:Monika is: "+map.get("Monika"));
        System.out.println("value for key:null is: "+map.get(null));
        System.out.println("value for key:Vicky is: "+map.get("Vicky"));
        
    }
}
