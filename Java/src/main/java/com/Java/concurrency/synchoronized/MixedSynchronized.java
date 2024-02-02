package com.Java.concurrency.synchoronized;

public class MixedSynchronized {
    public static  Object object=null;
    public static synchronized void setObject(Object obj){
        object=obj;
    }
    public Object obj =null;
    public  synchronized void setInstanceObject(Object object){
        this.obj=object;
    }
}
