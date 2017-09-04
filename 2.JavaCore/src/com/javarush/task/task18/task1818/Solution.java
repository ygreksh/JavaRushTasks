package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileOutputStream fout1 = new FileOutputStream(file1);
        FileInputStream fin2 = new FileInputStream(file2);
        FileInputStream fin3 = new FileInputStream(file3);

        byte[] buffer2 = new byte[fin2.available()];
        byte[] buffer3 = new byte[fin3.available()];

        fin2.read(buffer2);
        fin3.read(buffer3);
        fout1.write(buffer2);
        fout1.write(buffer3);

        reader.close();
        fout1.close();
        fin2.close();
        fin3.close();
    }
}
