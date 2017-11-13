package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) {
        this.providers = providers;
        if (providers.length == 0) throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<Vacancy> vacancyList = new ArrayList<>();
        for (Provider provider : providers){
            vacancyList.addAll(provider.getJavaVacancies(""));
        }

        System.out.println(vacancyList.size());

    }
}
