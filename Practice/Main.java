
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread Using Runnable Interface");
    }

}

class Main1 {

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.print("Thread using Thread class");
    }
}

class Main {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

    }
}
