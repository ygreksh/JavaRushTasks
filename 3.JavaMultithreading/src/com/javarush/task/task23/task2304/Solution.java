package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/*
Inner 3
*/
public class Solution {

    private class TaskDataProvider extends DbMock implements DbDataProvider<Task>{
        @Override
        public void refreshAllData(Map criteria) {
            tasks = getFakeTasks(criteria);
        }
    }
    private class NameDataProvider extends DbMock implements DbDataProvider<String>{
        @Override
        public void refreshAllData(Map criteria) {
            names = getFakeNames(criteria);
        }
    }


    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {

    }

    public static void main(String[] args) {

    }
}
