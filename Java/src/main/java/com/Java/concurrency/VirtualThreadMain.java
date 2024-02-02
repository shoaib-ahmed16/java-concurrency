package com.Java.concurrency;
public class VirtualThreadMain {
    public static void main(String[] args){
        Runnable runnable =() -> {
            for(int i=0;i<10;i++){
                System.out.println("Index : "+i);
            }
        };
        Thread vThread1 = Thread.ofVirtual().name("FIRST Virtual Thread....").start(runnable);

        //Example 2: Create but do not start Virtual thread.
        Thread vThreadUnStarted = Thread.ofVirtual().name("SECOND Virtual Thread....").unstarted(runnable);
        vThreadUnStarted.start();

        try{
            vThread1.join();
            vThreadUnStarted.join();
        }catch(InterruptedException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
