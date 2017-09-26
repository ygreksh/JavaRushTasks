package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static class Handler extends Thread{
        public Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;

        }
    }
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) throws IOException {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()){
            Connection connection = entry.getValue();
            try {
                connection.send(message);
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println( entry.getKey() + " сообщение не передано");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен");
            while (true){
                    Socket socket = serverSocket.accept();
                    Handler handler = new Handler(socket);
                    handler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
