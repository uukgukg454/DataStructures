package designpattern;

public class Singleton {

    public static void main (String [] args) {

        /*Test obj1 = Test.getInstance();
        Test obj2 = Test.getInstance();*/

        /*Test1 obj3 = Test1.getInstance();
        Test1 obj4 = Test1.getInstance();*/

        /*Thread t1= new Thread("thread1") {
            @Override
            public void run() {
                System.out.println("Inside run method of --> "+Thread.currentThread().getName());
                Test2.getInstance();
            }
        };

        Thread t2= new Thread("thread2") {
            @Override
            public void run() {
                System.out.println("Inside run method of --> "+Thread.currentThread().getName());
                Test2.getInstance();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Thread t3= new Thread("thread3") {
            @Override
            public void run() {
                Test3.getInstance();
            }
        };

        Thread t4= new Thread("thread4") {
            @Override
            public void run() {
                Test3.getInstance();
            }
        };

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//Lazy Loading
class Test
{
    private static Test obj;

    private Test() {
        System.out.println("inside Test constructor");
    }

    public static Test getInstance() {
        if(obj==null) {
            obj= new Test();
        }
        return obj;
    }
}

//Eager Initialization
class Test1
{
    private static final Test1 obj = new Test1();

    private Test1() {
        System.out.println("inside Test1 constructor");
    }

    public static Test1 getInstance() {
        return obj;
    }
}

//Thread-safe and Lazy initialization
class Test2
{
    private static  Test2 obj;

    private Test2() {
        System.out.println("inside Test2 constructor");
    }

    public synchronized static Test2 getInstance() {
            if(obj==null) {
              obj= new Test2()  ;
            }
            return obj;
        }
}

//Double  checkedLocking
class Test3
{
    private static Test3 obj;

    private Test3() {
        System.out.println("inside Test3 constructor");
    }

    public static Test3 getInstance() {
        if (obj==null) {
            synchronized (Test3.class) {
                if(obj==null) {
                    obj= new Test3();
                }
        }
      }
        return obj;
    }
}




