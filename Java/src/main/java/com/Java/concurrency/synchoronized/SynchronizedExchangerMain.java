package com.Java.concurrency.synchoronized;

public class SynchronizedExchangerMain {

    public static  void main(String[] args){
        SynchronizedExchanger exchanger = new SynchronizedExchanger();
        Thread thread1= new Thread(()->{
            for(int i=0;i<1000;i++){
                exchanger.setObject(""+i);
            }
        });

        Thread thread2= new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println("Printing value of Object :"+exchanger.getObject());
            }
        });

        thread1.start();
        thread2.start();
    }
}
