package com.acabes.assignments.java.threads;

public class OddAndEvenThreads extends Thread {

    public void run() {
        if (currentThread().getName().equals("even")) {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        }
        if (currentThread().getName().equals("odd")) {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        OddAndEvenThreads thread = new OddAndEvenThreads();
        Thread t1 = new Thread(thread, "even");
        Thread t2 = new Thread(thread, "odd");

        t1.start();
        t1.join();
        t2.start();
    }
}
