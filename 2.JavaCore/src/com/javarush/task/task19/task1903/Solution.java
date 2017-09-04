package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private  IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phoneNumber = this.data.getPhoneNumber() + "";
            String nulls = "";
            if (phoneNumber.length()<10) {
                for (int i =0; i < (10-phoneNumber.length()); i++)
                {
                    nulls = nulls+"0";
                }
            }
            phoneNumber = nulls + phoneNumber;
            String firstPart = phoneNumber.substring(0, 3);
            String secondPart = phoneNumber.substring(3, 6);
            String thirdPart = phoneNumber.substring(6, 8);
            String fourthPart = phoneNumber.substring(8);
            return "+"+this.data.getCountryPhoneCode()+"("+firstPart+")"+secondPart+"-"+thirdPart+"-"+fourthPart;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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