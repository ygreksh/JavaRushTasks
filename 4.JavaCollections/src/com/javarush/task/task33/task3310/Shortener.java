package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = Long.valueOf(0);
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    synchronized public Long getId(String string){
        if (storageStrategy.containsValue(string)) return storageStrategy.getKey(string);
        else {
            lastId ++;
            storageStrategy.put(lastId,string);
            return lastId;
        }
    }
    synchronized public String getString(Long id){
        return storageStrategy.getValue(id);
    }
}
