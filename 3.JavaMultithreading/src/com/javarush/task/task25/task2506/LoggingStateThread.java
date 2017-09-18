package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        //super.run();
        State state = thread.getState();
        System.out.println(state);
        while (state!=State.TERMINATED){
            State newState = thread.getState();
            if (!newState.equals(state)){
                state = newState;
                System.out.println(state);
            }
        }
    }
}