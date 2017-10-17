package com.javarush.task.task27.task2712.ad;

public class AdvertisementStorage {
    private static AdvertisementStorage instanse;
    private AdvertisementStorage(){
    }
    public static AdvertisementStorage getInstanse(){
        if (instanse == null){
            instanse = new AdvertisementStorage();
        }
        return instanse;
    }
}
