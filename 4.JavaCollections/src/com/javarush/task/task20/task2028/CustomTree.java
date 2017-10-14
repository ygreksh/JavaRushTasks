package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
        list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(list);
        System.out.println("size:" + list.size() + "; removing 14: " + list.remove("14") + "; size after:" + list.size());
        list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("size:" + list.size() + "; removing 2: " + list.remove("2") + "; size after:" + list.size());
        System.out.println("size:" + list.size() + "; removing 2: " + list.remove("5") + "; size after:" + list.size());
        list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        list.remove("3");
        ((CustomTree) list).add("16");
        System.out.println(list);
    }
    @Override
    public String toString() {
        String s = "";
        for (int i = 1; i < this.size(); i++) {
            Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
            queue.add(root);
            boolean flag = true;
            while (queue.size() != 0) {
                Entry<String> currentElement = queue.remove();
                if (currentElement.lineNumber == i) {
                    if (flag) {
                        s += i + ":";
                    }
                    s += currentElement.elementName + ",";
                    flag = false;
                }
                if (currentElement.leftChild != null) {
                    queue.add(currentElement.leftChild);
                }
                if (currentElement.rightChild != null) {
                    queue.add(currentElement.rightChild);
                }
            }
            if (flag) { break; }
            s += "\r\n";
        }
        return s;
    }

    Entry<String> root = new Entry<>("0");

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber = 0;
        boolean availableToAddLeftChildren,
                availableToAddRightChildren;
        Entry<T> parent,
                leftChild,
                rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddRightChildren || availableToAddLeftChildren;
        }
    }

    public boolean add(String element) {
        Entry<String> newElement = new Entry<>(element);
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (true) {
            Entry<String> currentRoot = queue.remove();
            // если находим локальный "корень" у которого нет 1 или 2=х "детей", то записываем
            if (currentRoot.isAvailableToAddChildren()) {
                elementAdd(currentRoot, newElement);
                break;
            } // если дети есть, то ставим их в очередь
            else {
                if (currentRoot.leftChild != null)
                    queue.add(currentRoot.leftChild);
                if (currentRoot.rightChild != null)
                    queue.add(currentRoot.rightChild);
            }
        }
        return true;
    }

    @Override
    public String get(int index) {
        return null;
    }

    //проверяет наличие детей и запихивает туда, где их нет
    public void elementAdd(Entry<String> currentRoot, Entry<String> currentElement) {
        if (currentRoot.availableToAddLeftChildren) {
            currentElement.parent = currentRoot;
            currentElement.lineNumber = currentRoot.lineNumber + 1;
            currentRoot.leftChild = currentElement;
        } else if (currentRoot.availableToAddRightChildren) {
            currentElement.parent = currentRoot;
            currentElement.lineNumber = currentRoot.lineNumber + 1;
            currentRoot.rightChild = currentElement;
        }
        currentRoot.checkChildren();
    }

    @Override
    public boolean remove(Object object) {
        String removeElementStr = (String) object;
        //ищем нужный элемент в графе и если он не null, удаляем
        Entry<String> removeElement = findElement(root, removeElementStr);
        if (removeElement != null) {
            if (removeElement.parent.leftChild != null && removeElement.parent.leftChild.elementName.equals(removeElement.elementName))
                removeElement.parent.leftChild = null;
            else removeElement.parent.rightChild = null;
            removeElement.parent = null;
        }
        return true;
    }

    //метод ищет указанный элемент в графе и взвращает его или null, если его нет
    public Entry<String> findElement(Entry<String> root, String findElement) {
        Entry<String> elementOut = null;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.elementName.equals(findElement)) {
                elementOut = currentElement;
                break;
            } else {
                if (currentElement.leftChild != null)
                    queue.add(currentElement.leftChild);
                if (currentElement.rightChild != null)
                    queue.add(currentElement.rightChild);
            }
        }
        return elementOut;
    }

    @Override
    public int size() {
        int size = 0;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        // пробегаемся по элементам
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                queue.add(currentElement.leftChild);
                size++;
            }
            if (currentElement.rightChild != null) {
                queue.add(currentElement.rightChild);
                size++;
            }
        }
        return size;
    }

    public String getParent(String element) {
        Entry<String> findElement = findElement(root, element);
        if (findElement != null)
            return findElement.parent.elementName;
        else return null;
    }
}