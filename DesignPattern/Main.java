package DesignPattern;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Runnable task = () -> {
        // SingleTon singleTon = SingleTon.getInstance();
        // System.out.println(singleTon);
        // };

        // Thread thread1 = new Thread(task);
        // Thread thread2 = new Thread(task);

        // thread1.start();
        // thread2.start();

        Runnable task = () -> {
            SingleTon singleton = SingleTon.getInstance();
            System.out.println("Singleton instance: " + singleton);
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
