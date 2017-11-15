package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();
    private static boolean isExist = false;

    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        CurrencyManipulator currencyManipulator;

        if (map.containsKey(currencyCode.toLowerCase()))
            return map.get(currencyCode.toLowerCase());
        else {
            currencyManipulator = new CurrencyManipulator(currencyCode.toLowerCase());
            map.put(currencyCode.toLowerCase(), currencyManipulator);
            return currencyManipulator;
        }
    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
