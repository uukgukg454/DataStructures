package thread;

public class DeadLock {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String [] args) throws InterruptedException {

        Thread t1 = new Thread("thread1") {
            @Override
            public void run () {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName()+"--->acquired lock1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"--->waiting to acquire lock2");
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName()+"--->acquired both locks");
                    }
                }
            }
        };

        Thread t2 = new Thread("thread2") {
            @Override
            public void run () {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName()+"--->acquired lock2");
                    System.out.println(Thread.currentThread().getName()+"--->waiting to acquire lock1");
                    synchronized (lock1) {
                        System.out.println("got both locks");
                    }
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
