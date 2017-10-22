package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        //byte[] buff = byteArrayOutputStream.toByteArray();
        //String s1 = String.valueOf(buff);
        MessageDigest messageDigest = null;
        StringBuilder hexString = new StringBuilder();
        messageDigest = MessageDigest.getInstance("md5");
        messageDigest.reset();
        messageDigest.update(byteArrayOutputStream.toByteArray());
        byte[] newbytes = messageDigest.digest();
        for (int i = 0; i < newbytes.length; i++) {
            hexString.append(Integer.toHexString(0xFF & newbytes[i]));
        }
        return hexString.toString().equals(md5);
        /*
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(byteArrayOutputStream.toByteArray());
        */
        //return false;
    }
}
