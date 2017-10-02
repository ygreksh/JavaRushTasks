package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command{
    public ZipFileManager getZipFileManager() throws Exception{
        String StringZipPath = ConsoleHelper.readString();
        Path path = Paths.get(StringZipPath);
        ZipFileManager zipFileManager = new ZipFileManager(path);
        //zipFileManager.createZip(path);
        return zipFileManager;
    }
}
