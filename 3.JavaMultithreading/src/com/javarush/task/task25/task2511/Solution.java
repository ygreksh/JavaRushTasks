package com.javarush.task.task25.task2511;


import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler(){

            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                String ThreafName = thread.getName();
                String Message = throwable.getMessage();
                char[] chars = new char[ThreafName.length()];
                for (int i=0;i<chars.length;i++){
                    chars[i]='*';
                }
                String newThreadName = String.valueOf(chars);
                //System.out.println(newThreadName + throwable.getMessage());
                String newMessage = Message.replaceAll(ThreafName,newThreadName);
                Exception e = new Exception(newMessage,throwable);
                System.out.println(e.getMessage());
            }
        };     //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
}