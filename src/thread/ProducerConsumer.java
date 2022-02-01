package thread;

import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumer {

    private static final ArrayList<Integer> list = new ArrayList<>();

    private static final int capacity = 4;

    private void produce() throws InterruptedException {
        int value = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName()+"--->producer trying to acquire lock");
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName()+"----->producer acquired lock and checking list size in producer,size--->"+list.size());
                    while (list.size() == capacity) {
                        System.out.println(Thread.currentThread().getName()+"---->producer is going to wait");
                        wait();
                        System.out.println(Thread.currentThread().getName()+"----->producer resumed........");
                    }
                    System.out.println(Thread.currentThread().getName()+"---->producing message::" + value);
                    list.add(value++);
                    notify();
                    Thread.sleep(1000);
            }
        }
    }

    private void consume() throws InterruptedException {
        while (true) {
            System.out.println("consumer trying to acquire lock");
            synchronized (this) {
                System.out.println("consumer acquired lock  and checking list size in consumer,size--->"+list.size());
                while (list.size() == 0) {
                    System.out.println("consumer is going to wait");
                    wait();
                    System.out.println("consumer resumed........");
                }
                System.out.println("consumed message::" +  list.remove(0));
                notify();
                Thread.sleep(3000);
            }
        }
    }

    public static void spawnThreads1() throws InterruptedException {
        ProducerConsumer obj = new ProducerConsumer();
        Thread t1 = new Thread("producerThread1") {
            @Override
            public void run() {
                try {
                    obj.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread("consumerThread") {
            @Override
            public void run() {
                try {
                    obj.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static void spawnThreads2() throws InterruptedException {
        Buffer buffer = new Buffer(5);
        int value = 0;
        Thread t1 = new Thread("producerThread1") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Random r = new Random();
                        int value = r.nextInt(10);
                        System.out.println("produced message--->"+value);
                        buffer.add(value);
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
                        System.out.println("consumed message--->"+buffer.remove());
                        Thread.sleep(3000);
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

    public static void main(String args[]) throws InterruptedException {
        //spawnThreads1();
        spawnThreads2();

    }
}

class Buffer {

    private final int capacity;

    private final ArrayList<Integer> list;

    public Buffer(int capacity) {
        this.list = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(int value) throws InterruptedException {
        synchronized (this) {
            if(list.size()==capacity) {
                wait();
            }
            list.add(value);
            notify();
        }
    }

    public int remove() throws InterruptedException {
        synchronized (this) {
            if(list.size()==0) {
                wait();
            }
            notify();
            return list.remove(0);
        }
    }
}
