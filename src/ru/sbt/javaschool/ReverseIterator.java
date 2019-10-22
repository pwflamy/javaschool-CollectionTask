package ru.sbt.javaschool;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Реализация итератора, выполняющего обход списка
 * в обратном направлении.
 */
public class ReverseIterator<T> implements Iterator<T> {
    private List<T> list;
    private int current;

    public ReverseIterator(List<T> list) {
        this.list = list;
        current = list.size()-1;
    }

    @Override
    public boolean hasNext() {
        return current != -1;
    }

    @Override
    public T next() {
        try {
            int i = current;
            T next = list.get(i);
            current = i - 1;
            return next;
        }
        catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }
}
