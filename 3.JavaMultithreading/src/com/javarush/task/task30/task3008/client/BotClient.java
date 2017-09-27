package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.util.Random;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread{

    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        /*
        int number = (int) Math.random()*100;
        String botname = String.format("date_bot_%d",number);
        return botname;
        */
        /*
        Random random = new Random();
        return "date_bot_" + (random.nextInt(99) + 1);
        */
        String botName = "date_bot_" + ((int)(Math.random()*100));
        return botName;
    }
    public static void main(String[] args) throws IOException {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
