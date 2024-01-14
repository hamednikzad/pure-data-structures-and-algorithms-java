package com.hamednikzad.lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayList {
    static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE - 8;
    private Object[] items;
    private int size;
    private int capacity;

    public int getCount() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList() {
        items = new Object[size];
        capacity = 4;
    }

    public ArrayList(int c) throws Exception {
        if (c < 0)
            throw new Exception("Capacity should be non negatice");

        items = new Object[c];
        capacity = c;
    }

    public Object getAt(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Index is out of range");
        }

        return items[index];
    }

    public void add(Object value) throws Exception {
        if (size == items.length)
            checkCapacity(size + 1);

        items[size] = value;
        size++;
    }

    private void checkCapacity(int s) throws Exception {
        if (items.length >= size)
            return;

        int newCapacity = items.length == 0 ? 4 : items.length * 2;
        if (newCapacity > MAXIMUM_CAPACITY) newCapacity = MAXIMUM_CAPACITY;
        if (newCapacity < size) newCapacity = size;

        changeCapacity(newCapacity);
    }

    private void changeCapacity(int newCapacity) throws Exception {
        if (newCapacity < size)
            throw new Exception("newCapacity Out of range");

        if (newCapacity == capacity)
            return;

        if (newCapacity > 0) {
            var newItems = new Object[newCapacity];

            if (size > 0) {
                System.arraycopy(items, 0, newItems, 0, size);
            }

            items = newItems;
        } else {
            items = new Object[4];
            size = 0;
        }

        capacity = newCapacity;
    }

    public void clean(){
        if(size == 0) return;

        Arrays.fill(items, 0);

        size = 0;
    }

    public boolean contains(Object item){
        if(item == null){
            for (int i = 0; i < size; i++) {
                if(items[i] == null)
                    return true;
            }

            return false;
        }else{
            for (int i = 0; i < size; i++) {
                if(items[i].equals(item))
                    return true;
            }

            return false;
        }
    }

}
