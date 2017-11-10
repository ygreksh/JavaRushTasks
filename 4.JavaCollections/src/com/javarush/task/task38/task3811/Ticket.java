package com.javarush.task.task38.task3811;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Ticket {
    //3) Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
    public enum Priority {LOW, MEDIUM, HIGH}

    //4) Приоритет будет задавать свойство priority — по умолчанию Priority.MEDIUM.
    Priority priority() default Priority.MEDIUM;

    //5) Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
    String[] tags() default {};

    //6) Свойство createdBy будет строкой — по умолчанию Amigo.
    String createdBy() default "Amigo";
}
