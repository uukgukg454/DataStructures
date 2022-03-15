package datastructure.heap;

public class HeapOperation {

    public static void main(String [] args) {
        Heap maxHeap = new Heap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.printAllElements();
        maxHeap.extractMax();
        System.out.println("\n");
        maxHeap.printAllElements();
    }
}

class Heap {
    private int size;
    private final int maxSize;
    private final int[] heap;

    public Heap(int capacity) {
        this.size=0;
        this.maxSize= capacity;
        heap = new int[capacity];
    }

    private int getParent(int pos) {
        return (pos - 1)/2;
    }

    private int getLeftChild(int pos) {
        return (2*pos)+1;
    }

    private int getRightChild(int pos) {
        return (2*pos)+2;
    }

    public void insert(int key) {
        if(size==maxSize) {
            System.out.println("heap is full. Insert Failed");
            return;
        }
        int current = size;
        heap[current]= key;
        size++;
        heapifyUp(current);
    }

    private void heapifyUp(int currentPos) {
        int temp;
        while(getParent(currentPos)>=0 && heap[currentPos]>heap[getParent(currentPos)]) {
            temp =  heap[getParent(currentPos)];
            heap[getParent(currentPos)]= heap[currentPos];
            heap[currentPos]=temp;
            currentPos= getParent(currentPos);
        }
    }

    public int extractMax() {
        int max = heap[0];
        heap[0]= heap[size-1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int i) {
            int largest = i;
            int left = getLeftChild(i);
            int right = getRightChild(i);
            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != i) {
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;
                heapifyDown(largest);
            }
    }

    public void printInParentChildFashion()
    {
        for (int i = 0; i <= size / 2; i++) {
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i + 1]
                            + " RIGHT CHILD :" + heap[2 * i + 2]);
            System.out.println();
        }
    }

    public void printAllElements()
    {
        for(int i=0;i<size;i++)
            System.out.print(heap[i]+ " ");
    }
}
