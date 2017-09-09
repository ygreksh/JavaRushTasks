package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move(){
        for (Horse h : horses){h.move();}
    }
    public void print(){
        for (Horse h : horses){h.print();}
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public void run() throws InterruptedException {
        for (int i=1; i<=100;i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public Horse getWinner(){
        Horse winner=horses.get(0);
        for (Horse h : horses){
            if (h.getDistance()>winner.getDistance()) winner=h;
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName()+"!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Сивка",3,0));
        game.getHorses().add(new Horse("Бурка",3,0));
        game.getHorses().add(new Horse("Каурка",3,0));
        game.run();
        game.printWinner();
    }
}
