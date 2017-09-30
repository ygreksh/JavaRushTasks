package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.Command;
import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к архиву (куда архивировать):");
        String fullZipPath = reader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fullZipPath));
        System.out.println("Введите полный путь к файлу (что архивировать):");
        String fullSourcePath = reader.readLine();
        zipFileManager.createZip(Paths.get(fullSourcePath));
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
        */
        Operation operation = null;
        while(operation != Operation.EXIT){
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
                //if ();
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e){
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }
    }
    public static Operation askOperation() throws IOException{
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - Создать архив");
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - Добавить в архив");
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - Извлечь из архива");
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - Показать содержимое архив");
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - Удалить архив");
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - Выход");

        int numberOfCommand = ConsoleHelper.readInt();
        //Operation operation;
        for (Operation op : Operation.values()){
            if (op.ordinal() == numberOfCommand) return op;
        }
        return null;
    }
}
