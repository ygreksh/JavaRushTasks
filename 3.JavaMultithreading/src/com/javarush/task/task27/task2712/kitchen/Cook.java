package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg) {
        Order order = (Order) arg;
        Tablet tablet = (Tablet) observable;
        if (!order.isEmpty()) {
            //StatisticManager.getInstance().register(new CookedOrderEventDataRow(tablet.toString(), this.name, order.getTotalCookingTime() * 60, order.getDishes()));
            ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
            setChanged();
            StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),this.toString(),order.getTotalCookingTime()*60,order.getDishes()));
            notifyObservers(order);
        }
    }
}
