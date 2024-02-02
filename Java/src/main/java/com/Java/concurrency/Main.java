package com.Java.concurrency;

public class Main {
    public static  void main(String[] args){

//        There are four ways to create Threads in Java.
//        1. Create a class which will Extends the Thread Class and then override the run method and write your implementation and the logic in this  method.
        ThreadApproach1 thread1 = new ThreadApproach1();
        thread1.setName("I am Thread 1");
        thread1.start();

//        2. Create a class that implements the Runnable interface  and then pass this class object as argument in Thread and then start the thread.
        ThreadApproach2 threadObj= new ThreadApproach2();
        Thread thread2= new Thread(threadObj);
        thread2.setName("I am Thread 2");
        thread2.start();

//        3. Creating an anonymous implemention of the Runnable interface and
        Thread thread3= new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=21;i<30;i++){
                    System.out.println("Printing the value using parallel thread: "+Thread.currentThread().getName()+": "+i);
                }
            }
        });
        thread3.setName("I am Thread 3");
        thread3.start();

//        4. is using lambda expression
        Thread thread4 = new Thread(() -> {
            for (int i = 21; i < 30; i++) {
                System.out.println("Printing the value using parallel thread: " + Thread.currentThread().getName() + ": " + i);
            }
        });
        thread4.setName("I am Thread 4");
        thread4.start();

        for (int i=31;i<40;i++){
            System.out.println("Printing the value using parallel thread: " + Thread.currentThread().getName() + ": " + i);
        }



    }
}

