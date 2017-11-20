package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {

            Socket clientSocket = new Socket(url.getHost(), 80);
            //получаем OutputStream
            OutputStream outputStream = clientSocket.getOutputStream();

            String request = "GET "+url.getFile()+" HTTP/1.1\r\n";
            request +="Host: "+url.getHost()+"\r\n\r\n";

            outputStream.write(request.getBytes());
            outputStream.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}