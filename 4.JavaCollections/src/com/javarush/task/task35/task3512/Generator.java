package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> clazz;

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        //clazz = new T();
        return (T) clazz.newInstance();
    }
}
