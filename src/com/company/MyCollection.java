package com.company;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

/*
interface ValueComparator<T> {
    boolean compare(T a, T b);
}
*/


//public class MyCollection<T extends Integer> implements Iterator<T>, Iterable<T> {
public class MyCollection<T> implements Iterator<T>, Iterable<T> {
    private T[] collection;
    private Class<T> classType;
    public int currentIndex;

    public MyCollection(Class<T> classType) {
        this.classType = classType;
        collection = (T[]) Array.newInstance(classType, 0);
        currentIndex = -1;
    }

    public T getByIndex(int index) {
        return collection[index];
    }

    public int getSize() {
        return collection.length;
    }

    public void add(T value) {
        T[] temp = (T[]) Array.newInstance(classType, collection.length + 1);

        for (int i = 0; i < collection.length; i++) {
            temp[i] = collection[i];
        }

        temp[temp.length - 1] = value;

        collection = temp;
    }

    public void sort(Comparator<T> comparator) {
        boolean isSort;
        T temp;
        int offset = 0;
        do {
            isSort = true;

            for (int i = 0; i < collection.length - 1 - offset; i++) {
                if (comparator.compare(collection[i], collection[i + 1]) < 0) {
                    temp = collection[i];
                    collection[i] = collection[i + 1];
                    collection[i + 1] = temp;

                    isSort = false;
                }
            }

            offset++;
        }
        while (isSort == false);
    }

    public MyCollection<T> getIfEqual(Predicate<T> equal) {
        MyCollection<T> filteredCollection = new MyCollection<>(classType);

        for (int i = 0; i < collection.length; i++) {
            if (equal.test(collection[i]) == true) {
                filteredCollection.add(collection[i]);
            }
        }

        return filteredCollection;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < collection.length - 1;
    }

    @Override
    public T next() {
        currentIndex++;
        return collection[currentIndex];
    }

    @Override
    public Iterator<T> iterator() {
        currentIndex = -1;
        return this;
    }
}
