package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            //return countries.get(customer.getCountryName());
            String countryName = customer.getCountryName();
            String countryCode = "";
            for (Map.Entry<String,String> entry : countries.entrySet()){
                if (countryName.equals(entry.getValue())) countryCode = entry.getKey();
            }
            return countryCode;

        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] names = contact.getName().split(", ");
            return names[1];
        }

        @Override
        public String getContactLastName() {
            String[] names = contact.getName().split(", ");
            return names[0];
        }

        @Override
        public String getDialString() {
            String phoneNumber = this.contact.getPhoneNumber();
            String rowDigits = phoneNumber.replaceAll("[()-]", "");
            //System.out.println(rowDigits);
            return "callto://"+rowDigits;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}