package com.Java.concurrency.synchoronized;

import java.util.Objects;

public class SharedMonitorObjects {

    private Object monitor = null;
    private int counter =0;
    public SharedMonitorObjects(Object monitor){
        if(Objects.isNull(monitor)){
            throw new RuntimeException("Monitor Object cannot be null.");
        }
        this.monitor =monitor;
    }
    public void incCounter(){
        synchronized (this.monitor){
            this.counter++;
        }
    }
}