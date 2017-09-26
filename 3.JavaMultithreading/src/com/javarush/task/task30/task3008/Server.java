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
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                if(message.getType()==MessageType.USER_NAME){
                    String userName = message.getData();
                    if(!userName.isEmpty() && userName!=null && !connectionMap.containsKey(userName)){
                        connectionMap.put(userName,connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return userName;
                    }

                }
            }
        }
        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()){
                String username = entry.getKey();
                if (!username.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, username));
                }
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType()==MessageType.TEXT){
                    String textMessage = userName + ": " + message.getData();

                    sendBroadcastMessage(new Message(MessageType.TEXT,textMessage));
                }else System.out.println("Сообщение не является текстом");
            }
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
