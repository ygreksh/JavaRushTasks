package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int Capasity = (int) Math.max(16, (collection.size()/.75f+1));
        map = new HashMap<>(Capasity);
        for(E iterator : collection){
            map.put(iterator,PRESENT);
        }
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
    public boolean isEmpty(){return map.isEmpty();}
    public boolean contains(Object o){return map.containsKey(o);}
    public void clear(){map.clear();}
    public boolean remove(Object o){return null == map.remove(o);}

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap)map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError();
        }

    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity"));
        out.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor"));
        for(E e:map.keySet()){
            out.writeObject(e);
        }
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        Set<E> set = new HashSet<>();
        for(int i =0;i<capacity;i++){
            set.add((E)in.readObject());
        }
        for(E e:set){
            map.put(e,PRESENT);
        }
    }
}
