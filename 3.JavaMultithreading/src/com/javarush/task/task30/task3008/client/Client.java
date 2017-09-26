package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() throws IOException {
        System.out.println("Введите адрес сервера:");
        String line = ConsoleHelper.readString();
        return line;
    }
    protected int getServerPort() throws IOException {
        System.out.println("Введите номер порта сервера:");
        int port = ConsoleHelper.readInt();
        return port;
    }
    protected String getUserName() throws IOException {
        System.out.println("Введите имя пользователя:");
        String userName = ConsoleHelper.readString();
        return userName;
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Сообщение не отправлено");
            clientConnected = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.run();
    }

    public void run() throws IOException {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error Waiting");
                try {
                    connection.close();
                } catch (IOException e1) {}
            }
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        }
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        while (clientConnected) {
            String message;
            if (!(message = ConsoleHelper.readString()).equalsIgnoreCase("exit")) {
                if (shouldSendTextFromConsole())
                    sendTextMessage(message);
            }
            else break;
        }

    }


    public class SocketThread extends Thread{

    }
}
