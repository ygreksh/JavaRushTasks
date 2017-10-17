package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    Object content;
    String name;
    long initialAmount;
    int hits;
    int duration;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
    }
}
