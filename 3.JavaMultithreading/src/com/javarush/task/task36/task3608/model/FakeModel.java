package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> newUsers = new ArrayList<>();
        newUsers.add(new User("A",1,1));
        newUsers.add(new User("B",2,1));
        newUsers.add(new User("C",3,1));
        modelData.setUsers(newUsers);
    }

    @Override
    public void loadDeletedUsers() {
        throw  new UnsupportedOperationException();
    }
}
