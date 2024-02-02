package com.Java.concurrency;

public class ThreadApproach1 extends Thread{

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Printing the value using parallel thread: "+Thread.currentThread().getName()+": "+i);
        }
    }
}
