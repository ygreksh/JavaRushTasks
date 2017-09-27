package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(": ")){
                String[] params = message.split(": ");
                String username = params[0];
                String text = params[1];
                String textdate = null;
                Date currentDate = new Date();
                SimpleDateFormat sdf;
            /*
            if (text.equals("дата")){
                SimpleDateFormat sdf = new SimpleDateFormat("d.MM.YYYY");
                Date currentDate = new Date());
                String tarxdate = sdf.format(currentDate);
            }*/
                switch (text) {
                    case "дата":
                        sdf = new SimpleDateFormat("d.MM.YYYY");
                        textdate = sdf.format(currentDate);
                        break;
                    case "день":
                        sdf = new SimpleDateFormat("d");
                        textdate = sdf.format(currentDate);
                        break;
                    case "месяц":
                        sdf = new SimpleDateFormat("MMMM");
                        textdate = sdf.format(currentDate);
                        break;
                    case "год":
                        sdf = new SimpleDateFormat("YYYY");
                        textdate = sdf.format(currentDate);
                        break;
                    case "время":
                        sdf = new SimpleDateFormat("H:mm:ss");
                        textdate = sdf.format(currentDate);
                        break;
                    case "час":
                        sdf = new SimpleDateFormat("H");
                        textdate = sdf.format(currentDate);
                        break;
                    case "минуты":
                        sdf = new SimpleDateFormat("m");
                        textdate = sdf.format(currentDate);
                        break;
                    case "секунды":
                        sdf = new SimpleDateFormat("s");
                        textdate = sdf.format(currentDate);
                        break;
                    default: textdate = null;
                }
                //if ()
                try {
                    connection.send(new Message(MessageType.TEXT, "информация для " + username + ": " + textdate));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
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

        String botName = "date_bot_" + ((int)(Math.random()*100));
        return botName;
    }
    public static void main(String[] args) throws IOException {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
