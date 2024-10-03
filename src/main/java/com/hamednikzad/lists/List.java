package com.hamednikzad.lists;

import java.util.Arrays;

public class List<T> {
    static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE - 8;
    private T[] items;
    private int size;
    private int capacity;

    public int GetCount() {
        return size;
    }

    public int GetCapacity() {
        return capacity;
    }

    public List() {
        items = (T[]) new Object[0];
        capacity = 0;
    }

    public List(int c) throws Exception {
        if (c < 0)
            throw new Exception("Capacity Should be non negative");

        items = (T[]) new Object[c];
        capacity = c;
    }

    private void CheckCapacity(int size) throws Exception {
        if (items.length >= size)
            return;
        int newCapacity = items.length == 0 ? 4 : items.length * 2;
        if (newCapacity > MAXIMUM_CAPACITY) newCapacity = MAXIMUM_CAPACITY;
        if (newCapacity < size) newCapacity = size;

        ChangeCapacity(newCapacity);
    }

    private void ChangeCapacity(int newCapacity) throws Exception {
        if (newCapacity < size)
            throw new Exception("Out of range");

        if (newCapacity == capacity)
            return;

        if (newCapacity > 0) {
            var newItems = (T[]) new Object[newCapacity];

            if (size > 0) {
                newItems = Arrays.copyOf(items, size);
            }

            items = newItems;
        } else {
            items = (T[]) new Object[0];
        }

        capacity = newCapacity;
    }

    public T getAt(int index) throws Exception {
        if (index < 0 || index >= size)
            throw new Exception("Out of range");

        return items[index];
    }

    public void setAt(int index, T value) throws Exception {
        if (index < 0 || index >= size)
            throw new Exception("Out of range");

        items[index] = value;
    }

    public void clear()
    {
        if (size <= 0) return;

        Arrays.fill(items, 0);
        size = 0;
    }

    public void add(T value) throws Exception {
        if (size == items.length) CheckCapacity(size + 1);
        items[size++] = value;
    }

    public void insert(int index, T value) throws Exception {
        if (index < 0 || index > size)
            throw new Exception("out of range");

        if (size == items.length) CheckCapacity(size + 1);
        if (index < size)
        {
            items = Arrays.copyOfRange(items, index + 1, size - index);
        }

        items[index] = value;
        size++;
    }

    public int indexOf(T value)
    {
        for (int i = 0; i < size; i++) {
            if(items[i] == value)
                return i;
        }
        return -1;
    }

    public boolean remove(T item) throws Exception {
        int index = indexOf(item);
        if (index >= 0)
        {
            removeAt(index);
            return true;
        }

        return false;
    }

    public void removeAt(int index) throws Exception {
        if (index < 0 || index >= size)
            throw new Exception("Out of range");

        size--;
        if (index < size)
        {
            items = Arrays.copyOfRange(items, index + 1, size - index);
        }

        items[size] = null;
    }
}
