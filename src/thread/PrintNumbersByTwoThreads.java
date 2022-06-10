package thread;

public class PrintNumbersByTwoThreads {

    private static final int LIMIT =10;

    volatile int i= 1;

    private void printEven() throws InterruptedException {
        Thread.sleep(2000);
        synchronized (this) {
            while (i <= LIMIT) {
                System.out.println(Thread.currentThread().getName() + ":::i:::" + i + "-----> going to check 'i' is even or not");
                while (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "------>" + i);
                    wait();
                }
                i++;
                notify();
            }
        }
    }

    private void printOdd() throws InterruptedException {
        synchronized (this) {
            while (i <= LIMIT) {
                System.out.println(Thread.currentThread().getName() + ":::i:::" + i + "-----> going to check 'i' is odd or not");
                while(i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "------>" + i);
                    wait();
                }
                i++;
                notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintNumbersByTwoThreads obj = new PrintNumbersByTwoThreads();
        Thread t1 = new Thread("evenThread") {
            @Override
            public void run() {
                try {
                    obj.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread("oddThread") {
            public void run() {
                try {
                    obj.printOdd();
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
}
