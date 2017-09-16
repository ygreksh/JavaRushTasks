package com.javarush.task.task25.task2503;

import java.util.*;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {

         List<Column> result = new ArrayList<>();
        Map<Integer, Column> map = new TreeMap<>();
        for (int i = 0; i < realOrder.length; i++) {
            map.put(realOrder[i], Column.values()[i]);
        }

        for (Map.Entry<Integer, Column> entry : map.entrySet()){
            if (entry.getKey() != -1)
                result.add(entry.getValue());
        }
        return result;

        /*
        List<Column> temp = new LinkedList<>();

        for (int i=0;i<realOrder.length;i++){
            if (realOrder[i]!=-1) temp.add(values()[i]);
        }

        List<Column> result = new LinkedList<>();
        for (int i=0; i<temp.size();i++){
            if (realOrder[i]!=-1)
            result.add(temp.get(realOrder[i]));
        }
        return result;*/
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        if (realOrder[ordinal()]!=-1)
        return true;
        else return false;
    }

    @Override
    public void hide() {
        //int temp=realOrder[ordinal()];
        realOrder[ordinal()]=-1;
        /*realOrder[ordinal()+1]=temp;
        for (int i=ordinal()+1;i<realOrder.length-1;i++){
            realOrder[i+1]=realOrder[i];
        }*/
    }
}
