package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к архиву (куда архивировать):");
        String fullZipPath = reader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fullZipPath));
        System.out.println("Введите полный путь к файлу (что архивировать):");
        String fullSourcePath = reader.readLine();
        zipFileManager.createZip(Paths.get(fullSourcePath));
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
