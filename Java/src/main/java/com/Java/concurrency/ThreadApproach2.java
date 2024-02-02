package com.Java.concurrency;
public class ThreadApproach2 implements Runnable{
    @Override
    public void run() {
        for(int i=11;i<20;i++){
            System.out.println("Printing the value using parallel thread: "+Thread.currentThread().getName()+": "+i);
        }
    }
}
