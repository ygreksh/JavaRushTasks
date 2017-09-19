package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
    Thread thread;
    //String threadName;
    @Override
    public void run() {
        //thread = new Thread(threadName);
        //System.out.println(thread.getName());
        //thread.start();


            while(!thread.isInterrupted()) {
                    System.out.println(thread.getName());
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
    }

    @Override
    public void start(String threadName) {
        //this.threadName = threadName;
        thread = new Thread(this,threadName);
        thread.start();
        //run();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
