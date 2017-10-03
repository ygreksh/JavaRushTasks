package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Доюавление файла в архив.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полный путь к файлу для добавления в архив:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.addFile(sourcePath);

            ConsoleHelper.writeMessage("Добавление в архив завершено.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Файл не найден.");
        }
    }
}
