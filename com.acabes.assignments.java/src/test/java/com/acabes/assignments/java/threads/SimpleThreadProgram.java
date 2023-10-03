package com.acabes.assignments.java.threads;

public class SimpleThreadProgram extends Thread{

    public void run(){
        for(int i=1; i<=10; i++){
            System.out.println(i);
            if(i==5){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        SimpleThreadProgram thread = new SimpleThreadProgram();

        thread.start();
    }
}
