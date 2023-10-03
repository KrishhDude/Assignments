package com.acabes.assignments.java.threads;

public class ThreadDifferentPriorities extends Thread{

    public void run(){
        System.out.println("I am " + currentThread().getName());
    }

    public static void main(String[] args) {

        ThreadDifferentPriorities thread = new ThreadDifferentPriorities();

        Thread t1 = new Thread( thread, "Thread 1");
        Thread t2 = new Thread( thread, "Thread 2");
        Thread t3 = new Thread( thread, "Thread 3");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }
}
