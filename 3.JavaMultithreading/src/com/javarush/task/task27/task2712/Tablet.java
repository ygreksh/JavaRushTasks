package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable{
    final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    public Order createOrder(){
        Order order = null;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
                try {
                    //StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advertisementManager.));
                    advertisementManager.processVideos();
                } catch (NoVideoAvailableException e) {
                    //StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime()*60));
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }
            }
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
            return null;
        }
    }

    public Tablet(int number) {
        this.number = number;
    }
    @Override
    public String toString() { return "Tablet{number=" + number + "}"; }
}
