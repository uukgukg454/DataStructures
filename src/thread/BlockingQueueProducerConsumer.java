package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducerConsumer {

    private final BlockingQueue<Integer> blockingQueue= new ArrayBlockingQueue<Integer>(10);

    int value =1;

    private static void spawnThreads1() throws InterruptedException {
        BlockingQueueProducerConsumer obj = new BlockingQueueProducerConsumer();
        Thread t1 = new Thread("producerThread1") {
            @Override
            public void run() {
                while(true) {
                    System.out.println(Thread.currentThread().getName()+"--->producing message:" + obj.value);
                    obj.blockingQueue.add(obj.value++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread("consumerThread") {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("consumed message:" + obj.blockingQueue.take());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static void spawnThreads2() throws InterruptedException {
        BlockingQueueProducerConsumer obj = new BlockingQueueProducerConsumer();
        Thread t1 = new Thread(new Producer(obj.blockingQueue));
        t1.setName("producerThread");
        Thread t2 = new Thread(new Consumer(obj.blockingQueue));
        t2.setName("consumerThread");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void main(String [] args) throws InterruptedException {
        spawnThreads2();
    }
}

class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    int value =1;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName()+"--->producing message:" + value);
                queue.add(value++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("consumed message:" + queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
